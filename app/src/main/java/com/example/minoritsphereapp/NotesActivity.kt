package com.example.minoritsphereapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.NotesPannelBinding

class NotesActivity : AppCompatActivity() {

    private lateinit var binding: NotesPannelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = NotesPannelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set URLs for buttons
        binding.iseResBtn.setOnClickListener {
            openUrl("https://drive.google.com/drive/folders/1WpPsiiYpLfFjCarUntdlbt4j5jM0aESb?usp=drive_link")
        }

        binding.cseResBtn.setOnClickListener {
            openUrl("https://drive.google.com/drive/folders/15pbP6bUXF9ycMR0ORkkeLgcU-crm24Gr?usp=drive_link")
        }

        binding.aimlResBtn.setOnClickListener {
            openUrl("https://drive.google.com/drive/folders/1aPh6Nbs43yQPz_lqp_kr7x43a5XsZvG4?usp=drive_link")
        }

        binding.backButton.setOnClickListener {
            finish() // Close the current activity and return to the previous one
        }

    }

    // Function to open the URL in the web browser
    private fun openUrl(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }
}
