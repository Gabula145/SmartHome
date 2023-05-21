package com.example.navapp1

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.navapp1.databinding.ActivityMain2Binding
import com.example.navapp1.databinding.ActivityMainBinding
import com.example.navapp1.databinding.FragmentFavoritesBinding

class MainActivity2 : AppCompatActivity() {
   // private lateinit var selectRoutine:ActivityMain2Binding
    private lateinit var ac_main: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     //   setContentView(R.layout.activity_main2)
       val binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val sharedPref=getSharedPreferences("mPrefs", Context.MODE_PRIVATE)
        val routine_Name=sharedPref.getString("routeName",null)

        binding.myButton2.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }
        val routinesList=layoutInflater.inflate(R.layout.fragment_routines_list,null)
        if (routine_Name!=null){
            val verticalLinear=binding.verticalLinear
            verticalLinear.addView(routinesList)
            var tVRouName=routinesList.findViewById<TextView>(R.id.tVRouName)
            tVRouName.text = "$routine_Name"

        }
    }

}