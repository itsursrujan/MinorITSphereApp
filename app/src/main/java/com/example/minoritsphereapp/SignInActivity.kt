package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.ActivitySignInBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        // Navigate to SignUpActivity
        binding.textView.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish() // Close SignInActivity when going to SignUpActivity
        }

        // Sign-in button functionality
        binding.button.setOnClickListener {
            Log.d("SignInActivity", "Sign-in button clicked")
            val email = binding.emailEt.text.toString().trim()
            val pass = binding.passET.text.toString().trim()

            if (email.isNotEmpty() && pass.isNotEmpty()) {
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("SignInActivity", "Sign-in successful")
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                        finish() // Close SignInActivity on successful sign-in
                    } else {
                        Log.e("SignInActivity", "Sign-in failed: ${task.exception?.message}")
                        Toast.makeText(this, "Sign-in failed: ${task.exception?.localizedMessage}", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                Toast.makeText(this, "Empty fields are not allowed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()

        // Check if user is already signed in
        if (firebaseAuth.currentUser != null) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Close SignInActivity if already signed in
        }
    }
}
