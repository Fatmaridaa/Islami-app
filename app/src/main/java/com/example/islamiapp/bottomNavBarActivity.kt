package com.example.islamiapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islamiapp.databinding.ActivityBottomNavBarBinding
import com.example.islamiapp.fragments.AhadesFragment
import com.example.islamiapp.fragments.QuranFragment
import com.example.islamiapp.fragments.RadioFragment
import com.example.islamiapp.fragments.SebhaFragment

class bottomNavBarActivity : AppCompatActivity() {

    lateinit var binding: ActivityBottomNavBarBinding
    //lateinit var bottomNavigationView : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()


        // initialFragment
        if (savedInstanceState == null) {
            showFragment(QuranFragment())
        }


        binding.bottomNavbar.setOnNavigationItemSelectedListener{

            when(it.itemId){
                R.id.nav_quran ->showFragment(QuranFragment())
                R.id.nav_hades ->showFragment(AhadesFragment())
                R.id.nav_sebha ->showFragment(SebhaFragment())
                R.id.nav_radio ->showFragment(RadioFragment())


            }
            return@setOnNavigationItemSelectedListener true
        }

    }


    fun showFragment(fragment: Fragment){

        val currentFragment = supportFragmentManager.findFragmentById(binding.fragmentContainer.id)
        if (currentFragment?.javaClass != fragment.javaClass){
            supportFragmentManager.beginTransaction()
                .replace(binding.fragmentContainer.id,fragment)
                .addToBackStack(null)
                .commit()
        }

    }

}
