package com.example.minoritsphereapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class AddPlacement : AppCompatActivity() {

    private lateinit var companyName: EditText
    private lateinit var packageAmount: EditText
    private lateinit var criteria: EditText
    private lateinit var date: EditText
    private lateinit var btnAddPlacement: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_placement)

        // Initialize views
        companyName = findViewById(R.id.companyName)
        packageAmount = findViewById(R.id.packageAmount)
        criteria = findViewById(R.id.criteria)
        date = findViewById(R.id.date)
        btnAddPlacement = findViewById(R.id.btnAddPlacement)

        btnAddPlacement.setOnClickListener {
            val name = companyName.text.toString().trim()
            val packageAmt = packageAmount.text.toString().trim()
            val criteriaText = criteria.text.toString().trim()
            val placementDate = date.text.toString().trim()

            if (name.isEmpty() || packageAmt.isEmpty() || criteriaText.isEmpty() || placementDate.isEmpty()) {
                Toast.makeText(this, "Please fill out all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            savePlacementToFirebase(name, packageAmt, criteriaText, placementDate)
        }
    }

    private fun savePlacementToFirebase(name: String, packageAmt: String, criteria: String, date: String) {
        val database = Firebase.database
        val placementRef = database.getReference("placements")

        val placementId = placementRef.push().key ?: return
        val placement = Placement(name, packageAmt, criteria, date)

        placementRef.child(placementId).setValue(placement)
            .addOnSuccessListener {
                Toast.makeText(this, "Placement added successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
            .addOnFailureListener {
                Toast.makeText(this, "Failed to add placement: ${it.message}", Toast.LENGTH_SHORT).show()
            }
    }
}
