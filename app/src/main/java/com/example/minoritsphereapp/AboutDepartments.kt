package com.example.minoritsphereapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minoritsphereapp.databinding.AboutDepartmentsBinding

class AboutDepartments : AppCompatActivity() {

    private lateinit var binding: AboutDepartmentsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = AboutDepartmentsBinding.inflate(layoutInflater)
        setContentView(binding.root) // Connect to the layout

        binding.iseInfoBtn.setOnClickListener {
            val intent = Intent(this, IseInfo::class.java)
            startActivity(intent)
        }
        binding.cseInfoBtn.setOnClickListener {
            val intent = Intent(this, CseInfo::class.java)
            startActivity(intent)
        }
        binding.aimlInfoBtn.setOnClickListener {
            val intent = Intent(this, AimlInfo::class.java)
            startActivity(intent)
        }
    }
}
