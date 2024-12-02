package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.AdminPannelBinding
import com.google.firebase.auth.FirebaseAuth

class AdminPannel : AppCompatActivity() { // Updated to match manifest
    private lateinit var binding: AdminPannelBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding
        binding = AdminPannelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize FirebaseAuth
        firebaseAuth = FirebaseAuth.getInstance()

        // Set up sign-out button click listener
        binding.signOutButton.setOnClickListener {
            firebaseAuth.signOut()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish() // Close AdminPannel after sign-out
        }
        binding.addEventBtn.setOnClickListener {
            val intent = Intent(this, AddEvent::class.java)
            startActivity(intent)
        }
        binding.addPlacementDetailsBtn.setOnClickListener {
            val intent = Intent(this, AddPlacement::class.java)
            startActivity(intent)
        }

        
    }
}

