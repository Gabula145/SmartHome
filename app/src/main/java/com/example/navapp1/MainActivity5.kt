package com.example.navapp1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.navapp1.databinding.ActivityMain3Binding
import com.example.navapp1.databinding.ActivityMain5Binding

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.messIcon.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }
        binding.text44444.setOnClickListener {
            val intent = Intent(this, MainActivity6::class.java)
            startActivity(intent)
        }

        binding.imageView6.setOnClickListener(){
            val intent=Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
    }
}