package com.example.islamiapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islamiapp.adapters.HadethContentAdapter
import com.example.islamiapp.adapters.SouraContentAdapter
import com.example.islamiapp.databinding.ActivityHadethContentBinding
import com.example.islamiapp.databinding.ActivitySouraContentBinding

class HadethContentActivity : AppCompatActivity() {

    var HadethTitle : String? = null
    var HadethDescription : String? = null
    lateinit var binding: ActivityHadethContentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHadethContentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        HadethTitle = intent.getStringExtra("HADITH_TITLE")
        HadethDescription = intent.getStringExtra("HADITH_DESCRIPTION")

        binding.hadesName.text= HadethTitle
        binding.hadesContentRecyclerView.adapter = HadethContentAdapter(HadethDescription?.split("\n") ?: listOf())


        binding.backBtn.setOnClickListener {
            finish()
        }


    }
}