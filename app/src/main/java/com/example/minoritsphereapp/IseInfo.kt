package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.IseInfoBinding

class IseInfo : AppCompatActivity() {

    private lateinit var binding: IseInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IseInfoBinding.inflate(layoutInflater)
        setContentView(binding.root) // Connect to the layout

    }
}