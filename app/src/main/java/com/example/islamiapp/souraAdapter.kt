package com.example.islamiapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.islamiapp.databinding.ItemSouraNameBinding

class souraAdapter (val soura : List<dataClass>) : RecyclerView.Adapter<souraAdapter.SouraViewHolder>() {


    class SouraViewHolder(val binding: ItemSouraNameBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SouraViewHolder {

        val binding = ItemSouraNameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SouraViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return soura.size
    }

    override fun onBindViewHolder(holder: SouraViewHolder, position: Int) {
        val item = soura[position]
        holder.binding.souraName.text = item.Name
        holder.binding.souraNumber.text = item.Number.toString()

    }


}