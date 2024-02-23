package com.example.myappdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappdemo.databinding.ItemSongBinding
import com.example.myappdemo.model.Song

class SongAdapter(private val mList: List<Song>):RecyclerView.Adapter<SongAdapter.ViewHolder>() {
    inner class ViewHolder(val binding:ItemSongBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(song: Song){
            binding.tvName.text = song.name
            binding.tvPath.text = song.path
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSongBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }
}