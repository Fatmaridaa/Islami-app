package com.example.islamiapp

import android.content.Intent
import android.os.Bundle
import android.os.Looper

import androidx.appcompat.app.AppCompatActivity
import java.util.logging.Handler

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)



        android.os.Handler().postDelayed({

            
        },3000)

        android.os.Handler(Looper.getMainLooper()).postDelayed({

            val intent = Intent(this , bottomNavBarActivity::class.java)
            startActivity(intent)
            finish()
        } , 3000 )

    }
}