package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        // Sign-out button functionality
        binding.signOutButton.setOnClickListener {
            firebaseAuth.signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Close MainActivity after sign-out
        }

        // Student Button Functionality
        binding.studentBtn.setOnClickListener {
            val intent = Intent(this, StudentPannel::class.java)
            startActivity(intent)
        }
        // Student Button Functionality
        binding.facultyBtn.setOnClickListener {
            val intent = Intent(this, FacultyPannel::class.java)
            startActivity(intent)
        }

    }

    override fun onStart() {
        super.onStart()

        // Check if the user is signed in; if not, redirect to SignInActivity
        if (firebaseAuth.currentUser == null) {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Close MainActivity if the user is not authenticated
        }
    }
}
