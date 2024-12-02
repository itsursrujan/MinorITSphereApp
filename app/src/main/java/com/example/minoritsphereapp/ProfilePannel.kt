package com.example.minoritsphereapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ProfilePannel : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_pannel)

        // Initialize FirebaseAuth
        auth = FirebaseAuth.getInstance()

        // Get the current user
        val currentUser = auth.currentUser
        val emailTextView = findViewById<TextView>(R.id.userEmailTextView)

        // Set the email to the TextView
        if (currentUser != null) {
            emailTextView.text = "Email: ${currentUser.email}"
        } else {
            emailTextView.text = "No user is currently logged in."
        }
    }
}
