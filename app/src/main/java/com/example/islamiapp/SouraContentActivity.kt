package com.example.islamiapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islamiapp.adapters.SouraContentAdapter
import com.example.islamiapp.databinding.ActivitySouraContentBinding
import com.example.islamiapp.databinding.ItemSouraContentBinding

class SouraContentActivity : AppCompatActivity() {

    var souraName : String? = null
    var souraNumber : Int? = null
    lateinit var binding: ActivitySouraContentBinding

    lateinit var adapter: SouraContentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySouraContentBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.backBtn.setOnClickListener {
            onBackPressed()
        }

        initParams()
        initViews()


    }

    fun initViews(){

        binding.souraName.text = souraName ?: "Unknown Soura"

        readVersesFromFile()
    }

    fun readVersesFromFile(){
        val allFileContent = assets.open("${souraNumber!! + 1}.txt").bufferedReader().use {
            it.readText()
        }

        val list = allFileContent.split("\n",)
        adapter = SouraContentAdapter(list)
        binding.souraContentRecyclerView.adapter = adapter
    }

    fun initParams(){
        souraName = intent.getStringExtra(constants.soura_name_extra)
        souraNumber = intent.getIntExtra(constants.soura_position_extra, -1)
    }
}