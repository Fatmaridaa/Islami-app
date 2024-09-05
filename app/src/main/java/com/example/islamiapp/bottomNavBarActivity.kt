package com.example.islamiapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class bottomNavBarActivity : AppCompatActivity() {
    lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bottom_nav_bar)

        // Set up the bottom navigation view
        bottomNavigationView= findViewById(R.id.bottom_navbar)
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener)

        // Set the initial fragment when the activity loads
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, RadioFragment())
                .commit()
        }
    }

    private val navListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        val selectedFragment: Fragment = when (item.itemId) {
            R.id.nav_radio -> RadioFragment()
            R.id.nav_sebha -> SebhaFragment()
            R.id.nav_hades -> AhadesFragment()
            R.id.nav_quran -> QuranFragment()
            else -> return@OnNavigationItemSelectedListener false
        }

        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_container)
        if (currentFragment?.javaClass != selectedFragment.javaClass) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit()
        }
        true
    }
}
