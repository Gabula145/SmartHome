package com.example.navapp1


import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.navapp1.databinding.ActivityMainBinding
import com.example.navapp1.ui.favorites.FavoritesFragment
import com.example.navapp1.ui.ideas.IdeasFragment
import com.example.navapp1.ui.routines.RoutinesFragment
import com.example.navapp1.ui.settings.SettingsFragment
import com.example.navapp1.ui.things.ThingsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val crtRoutData=intent.getStringExtra("toMain")

        //test code
        val sharedPref=getSharedPreferences("mPrefs", Context.MODE_PRIVATE)
        val routineName=sharedPref.getString("routeName",null)
        //test code
       // setSupportActionBar(binding.toolbar)
        loadFragment(FavoritesFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_favorites -> {
                    loadFragment(FavoritesFragment())
                    true
                }
                R.id.navigation_things -> {
                    loadFragment(ThingsFragment())
                    true
                }
                R.id.navigation_ideas -> {
                    loadFragment(IdeasFragment())
                    true
                }
                R.id.navigation_settings -> {
                    loadFragment(SettingsFragment())
                    true
                }
                R.id.navigation_routines -> {
                    if (routineName!=null){
                        loadFragment(return_routine())
                        val returnRoutine=layoutInflater.inflate(R.layout.fragment_return_routine, null)
                        val newRouName=returnRoutine.findViewById<TextView>(R.id.routineName)
                        newRouName.setText("$routineName")
                    }else{
                        loadFragment(RoutinesFragment())
                    }
                    true
                }
                else->{
                }

            }
            true
        }


        //
        if (routineName!=null){
            binding.bottomNavigationView.menu.findItem(R.id.navigation_routines).isChecked=true
            loadFragment(return_routine())

            val returnRoutine=layoutInflater.inflate(R.layout.fragment_return_routine, null)
            val newRouName=returnRoutine.findViewById<TextView>(R.id.routineName)
            newRouName.setText("$routineName")

        }


    }
    private fun loadFragment(fragment:Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }

}

