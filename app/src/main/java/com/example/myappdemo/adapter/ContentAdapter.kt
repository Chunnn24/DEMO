package com.example.myappdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappdemo.databinding.ItemContentBinding
import com.example.myappdemo.model.Content

class ContentAdapter(private val mList: List<Content>):RecyclerView.Adapter<ContentAdapter.ViewHolder>() {

    inner class ViewHolder(val binding:ItemContentBinding):RecyclerView.ViewHolder(binding.root){
        fun bin(content: Content){
            binding.tvName.text = content.tvName
            binding.tvPath.text = content.tvPath
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemContentBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bin(mList[position])
    }


    override fun getItemCount(): Int = mList.size

}