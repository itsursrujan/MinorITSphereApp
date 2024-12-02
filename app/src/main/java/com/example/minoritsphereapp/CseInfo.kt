package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.CseInfoBinding

class CseInfo : AppCompatActivity() {

    private lateinit var binding: CseInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CseInfoBinding.inflate(layoutInflater)
        setContentView(binding.root) // Connect to the layout

    }
}