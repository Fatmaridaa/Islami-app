package com.example.islamiapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islamiapp.SouraContentActivity
import com.example.islamiapp.constants
import com.example.islamiapp.dataClass
import com.example.islamiapp.databinding.FragmentQuranBinding
import com.example.islamiapp.adapters.souraAdapter
import com.example.islamiapp.callbacks.onSouraClickListner


class QuranFragment : Fragment() {
    lateinit var adapter: souraAdapter
    lateinit var binding: FragmentQuranBinding
    lateinit var souraList: MutableList<dataClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentQuranBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // Initialize the list of soura
        initList()

        // Set LayoutManager for RecyclerView
        binding.souraRecyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Initialize the adapter
        adapter = souraAdapter(souraList)
        adapter.onSouraClickListner=object :onSouraClickListner {
            override fun onSouraClick(soura: dataClass, position: Int) {
                val intent = Intent(requireActivity(), SouraContentActivity ::class.java)
                intent.putExtra(constants.soura_name_extra,soura.Name)
                intent.putExtra(constants.soura_position_extra,position)
                startActivity(intent)
            }

        }

        // Set adapter to RecyclerView
        binding.souraRecyclerView.adapter = adapter
    }

    fun initList(){

        souraList = mutableListOf()
        constants.soura.forEachIndexed { index, item ->
            souraList.add(dataClass(item, index + 1))
        }

    }

}