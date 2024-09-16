package com.example.islamiapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.adapters.souraAdapter.SouraViewHolder
import com.example.islamiapp.databinding.ItemSouraContentBinding
import com.example.islamiapp.databinding.ItemSouraNameBinding

class SouraContentAdapter (var Verseslist: List<String>?):
    RecyclerView.Adapter<SouraContentAdapter.SouraContentViewHolder>(){

    class SouraContentViewHolder(val binding: ItemSouraContentBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SouraContentViewHolder {

        val binding = ItemSouraContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SouraContentViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return Verseslist?.size ?: 0
    }

    override fun onBindViewHolder(holder: SouraContentViewHolder, position: Int) {

        val item = Verseslist?.get(position)

        holder.binding.content.text = "$item(${position+1})"

    }

}