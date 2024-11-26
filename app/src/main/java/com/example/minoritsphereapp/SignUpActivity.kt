package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        // Navigate to SignInActivity
        binding.textView.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Close SignUpActivity when going to SignInActivity
        }

        // Register button functionality
        binding.button.setOnClickListener {
            Log.d("SignUpActivity", "Sign-up button clicked")
            val email = binding.emailEt.text.toString().trim()
            val pass = binding.passET.text.toString().trim()
            val confirmPass = binding.confirmPassEt.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()) {
                if (pass == confirmPass) {
                    // Validate password
                    if (pass.length >= 8 && pass.any { it.isLetterOrDigit() } && pass.any { !it.isLetterOrDigit() }) {
                        firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                Log.d("SignUpActivity", "Sign-up successful")
                                Toast.makeText(this, "Account created successfully!", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, SignInActivity::class.java)
                                startActivity(intent)
                                finish() // Close SignUpActivity after successful registration
                            } else {
                                Log.e("SignUpActivity", "Sign-up failed: ${task.exception?.message}")
                                Toast.makeText(this, "Sign-up failed: ${task.exception?.localizedMessage}", Toast.LENGTH_SHORT).show()
                            }
                        }
                    } else {
                        Toast.makeText(this, "Password must be at least 8 characters long, alphanumeric, and include a special character.", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
