package com.example.navapp1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.navapp1.databinding.ActivityMain6Binding

class MainActivity6 : AppCompatActivity() {

    private lateinit var binding11:ActivityMain6Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding11=ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding11.root)


        binding11.textView11111.setOnClickListener(){
            val name = Intent(this, MainActivity3::class.java)
            name.putExtra("backR","back")
            startActivity(name)
        }

    }


    }
