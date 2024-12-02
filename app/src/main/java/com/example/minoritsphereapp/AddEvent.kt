package com.example.minoritsphereapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class AddEvent : AppCompatActivity() {

    private lateinit var eventName: EditText
    private lateinit var eventDescription: EditText
    private lateinit var eventDate: EditText
    private lateinit var eventTime: EditText
    private lateinit var btnAddEvent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_event)

        // Initialize views
        eventName = findViewById(R.id.eventName)
        eventDescription = findViewById(R.id.eventDescription)
        eventDate = findViewById(R.id.eventDate)
        eventTime = findViewById(R.id.eventTime)
        btnAddEvent = findViewById(R.id.btnAddEvent)

        // Set up button click listener
        btnAddEvent.setOnClickListener {
            val name = eventName.text.toString().trim()
            val description = eventDescription.text.toString().trim()
            val date = eventDate.text.toString().trim()
            val time = eventTime.text.toString().trim()

            if (name.isEmpty() || description.isEmpty() || date.isEmpty() || time.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            saveEventToFirebase(name, description, date, time)
        }
    }

    private fun saveEventToFirebase(name: String, description: String, date: String, time: String) {
        // Get reference to Firebase database
        val database = Firebase.database
        val eventsRef = database.getReference("events")

        // Generate unique ID for the event
        val eventId = eventsRef.push().key ?: return

        // Create event data
        val event = mapOf(
            "eventName" to name,
            "eventDescription" to description,
            "date" to date,
            "time" to time
        )

        // Save to Firebase
        eventsRef.child(eventId).setValue(event)
            .addOnSuccessListener {
                Toast.makeText(this, "Event added successfully", Toast.LENGTH_SHORT).show()
                finish() // Close the activity
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to add event: ${it.message}", Toast.LENGTH_SHORT).show()
            }


    }
}
