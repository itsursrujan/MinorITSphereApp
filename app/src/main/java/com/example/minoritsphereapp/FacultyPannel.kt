package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.FacultyPannelBinding

class FacultyPannel : AppCompatActivity() {

    private lateinit var binding: FacultyPannelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FacultyPannelBinding.inflate(layoutInflater)
        setContentView(binding.root)


        //add notes notes functionality
        binding.addNotesBtn.setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }


        // Back button functionality
        binding.backButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }
    }
}
