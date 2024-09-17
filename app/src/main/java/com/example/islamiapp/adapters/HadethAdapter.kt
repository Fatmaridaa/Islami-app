package com.example.islamiapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.islamiapp.HadethDataClass
import com.example.islamiapp.callbacks.onHadethClickListner
import com.example.islamiapp.databinding.ItemHadesBinding


class HadethAdapter (val Hadeth : List<HadethDataClass>) : RecyclerView.Adapter<HadethAdapter.HadethViewHolder>() {

    var onHadethClickListner: onHadethClickListner? = null

    class HadethViewHolder(val binding: ItemHadesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HadethViewHolder {
        val binding = ItemHadesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HadethViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return Hadeth.size
    }

    override fun onBindViewHolder(holder: HadethViewHolder, position: Int) {
        val item = Hadeth.get(position)
        holder.binding.itemHadeth.text = item.title


        holder.binding.itemHadeth.setOnClickListener {
            onHadethClickListner?.onHadethClick(item,position)
        }
    }


}