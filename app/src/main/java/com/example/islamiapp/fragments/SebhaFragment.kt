package com.example.islamiapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.islamiapp.R
import com.example.islamiapp.databinding.FragmentSebhaBinding


class SebhaFragment : Fragment() {

    var counter = 0
    lateinit var azkarList: MutableList<String>
    var currentIndex = 0
    lateinit var binding: FragmentSebhaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSebhaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        azkarList = resources.getStringArray(R.array.azkarList).toMutableList()
        binding.azkar.text = azkarList[0]

        onSebhaClick()
    }

    fun onSebhaClick() {
        var totalRotation = 0f

        binding.sebhaBody.setOnClickListener {
            totalRotation += (360f / 33)  // Increment the rotation

            // Apply the cumulative rotation
            binding.sebhaBody.rotation = totalRotation

            if (counter < 33) {
                counter++
            } else {
                counter = 0
                currentIndex = if (currentIndex < azkarList.size - 1) ++currentIndex else 0

                binding.azkar.text = azkarList[currentIndex]
            }
            binding.numberOfTasbeh.text = counter.toString()
        }
    }
}