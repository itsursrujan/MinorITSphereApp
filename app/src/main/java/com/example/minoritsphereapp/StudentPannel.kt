package com.example.minoritsphereapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.StudentPannelBinding

class StudentPannel : AppCompatActivity() {

    private lateinit var binding: StudentPannelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = StudentPannelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Back button functionality
        binding.backButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }
    }
}
