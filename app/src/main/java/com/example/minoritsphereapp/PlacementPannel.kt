package com.example.minoritsphereapp

import com.example.minoritsphereapp.ViewPlacements
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.PlacementPannelBinding

class PlacementPannel : AppCompatActivity() {

    private lateinit var binding: PlacementPannelBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PlacementPannelBinding.inflate(layoutInflater)
        setContentView(binding.root) // Connect to the layout

        binding.placementStatsBtn.setOnClickListener {
            val intent = Intent(this, PlacementStats::class.java)
            startActivity(intent)
        }
        binding.placementDetailsBtn.setOnClickListener {
            val intent = Intent(this, ViewPlacements::class.java)
            startActivity(intent)
        }

    }
}
