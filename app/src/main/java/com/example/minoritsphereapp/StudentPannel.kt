package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.StudentPannelBinding

class StudentPannel : AppCompatActivity() {

    private lateinit var binding: StudentPannelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = StudentPannelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // notes and resourses button
        binding.notesBtn.setOnClickListener {
            val intent = Intent(this, NotesActivity::class.java)
            startActivity(intent)
        }

        // Back button functionality
        binding.backButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }

        binding.aboutButton.setOnClickListener {
            val intent = Intent(this, AboutDepartments::class.java)
            startActivity(intent)
        }

        binding.placementsBtn.setOnClickListener {
            val intent = Intent(this, PlacementPannel::class.java)
            startActivity(intent)
        }
        binding.eventsBtn.setOnClickListener {
            val intent = Intent(this, ViewEvents::class.java)
            startActivity(intent)
        }
    }
}
