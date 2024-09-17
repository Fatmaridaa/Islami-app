package com.example.islamiapp.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.islamiapp.HadethContentActivity
import com.example.islamiapp.HadethDataClass
import com.example.islamiapp.adapters.HadethAdapter
import com.example.islamiapp.callbacks.onHadethClickListner
import com.example.islamiapp.constants
import com.example.islamiapp.databinding.FragmentAhadesBinding

class AhadesFragment : Fragment(), onHadethClickListner {
    private lateinit var binding: FragmentAhadesBinding
    lateinit var adapter: HadethAdapter
    lateinit var hadethList: MutableList<HadethDataClass>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAhadesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    fun initViews(){
        readHadethFile()
    }

    fun readHadethFile(){

        // read all the data from the file
        val allFileContent = requireContext().assets.open("ahadeth.txt").bufferedReader().use {
            it.readText()
        }

        // split each hadeth from the others
        val HadethListSplit = allFileContent.split("#")
        hadethList = mutableListOf()

        HadethListSplit.forEach { HadethDataClass ->
            val splittedHadeth = HadethDataClass.trim().split("\n")

            if (splittedHadeth.isNotEmpty()){
                val title = splittedHadeth[0]
                val description = if (splittedHadeth.size>1){
                    splittedHadeth.subList(1 , splittedHadeth.size).joinToString("\n")
                }else{
                    ""
                }

                hadethList.add(HadethDataClass(title, description))
            }

        }
        adapter = HadethAdapter(hadethList)
        adapter.onHadethClickListner = this
        binding.hadesRecyclerView.adapter = adapter

    }

    // Implement the interface method
    override fun onHadethClick(hadeth: HadethDataClass, position: Int) {
        val intent = Intent(requireContext(), HadethContentActivity::class.java).apply {
            putExtra("HADITH_TITLE", hadeth.title)
            putExtra("HADITH_DESCRIPTION", hadeth.description)
        }
        startActivity(intent)
    }





}
