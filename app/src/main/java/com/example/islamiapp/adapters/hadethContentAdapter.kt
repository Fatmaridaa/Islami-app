package com.example.islamiapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.adapters.souraAdapter.SouraViewHolder
import com.example.islamiapp.databinding.ItemHadethContentBinding
import com.example.islamiapp.databinding.ItemSouraContentBinding
import com.example.islamiapp.databinding.ItemSouraNameBinding

class HadethContentAdapter(
    private var hadethList: List<String> = listOf()
) : RecyclerView.Adapter<HadethContentAdapter.HadethContentViewHolder>() {

    class HadethContentViewHolder(val binding: ItemHadethContentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethContentViewHolder {
        val binding = ItemHadethContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HadethContentViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return hadethList.size
    }

    override fun onBindViewHolder(holder: HadethContentViewHolder, position: Int) {
        val item = hadethList[position]
        holder.binding.hadethContent.text = item
    }
}