package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.AimlInfoBinding

class AimlInfo : AppCompatActivity() {

    private lateinit var binding: AimlInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AimlInfoBinding.inflate(layoutInflater)
        setContentView(binding.root) // Connect to the layout

    }
}