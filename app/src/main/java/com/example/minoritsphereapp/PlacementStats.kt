package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.PlacementStatsBinding

class PlacementStats: AppCompatActivity() {

    private lateinit var binding: PlacementStatsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = PlacementStatsBinding.inflate(layoutInflater)
        setContentView(binding.root) // Connect to the layout
    }
}
