package com.example.islamiapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.callbacks.onSouraClickListner
import com.example.islamiapp.dataClass
import com.example.islamiapp.databinding.ItemSouraNameBinding

class souraAdapter (val soura : List<dataClass>) : RecyclerView.Adapter<souraAdapter.SouraViewHolder>() {

    var onSouraClickListner : onSouraClickListner? = null

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
        holder.binding.souraName.setOnClickListener{
            onSouraClickListner?.onSouraClick(item , position)
        }

    }


}