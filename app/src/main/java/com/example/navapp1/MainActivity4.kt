package com.example.navapp1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navapp1.databinding.ActivityMain4Binding
import com.example.navapp1.databinding.ActivityMain5Binding

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.arrowBack.setOnClickListener(){
            val intent= Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        binding.linear11.setOnClickListener(){
            val intentback= Intent(this, MainActivity3::class.java)
            intentback.putExtra("hello","MAXIMILLIAN")
            startActivity(intentback)
        }
    }

}




