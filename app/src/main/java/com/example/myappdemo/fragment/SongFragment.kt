package com.example.myappdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappdemo.R
import com.example.myappdemo.adapter.SongAdapter
import com.example.myappdemo.databinding.FragmentSongBinding
import com.example.myappdemo.model.Song


class SongFragment : Fragment() {

    private lateinit var binding:FragmentSongBinding
    val listSongs = arrayListOf(
        Song("Hello","Chung", R.mipmap.ic_launcher),
        Song("Hello","Chung", R.mipmap.ic_launcher),
        Song("Hello","Chung", R.mipmap.ic_launcher),
        Song("Hello","Chung", R.mipmap.ic_launcher),
        Song("Hello","Chung", R.mipmap.ic_launcher)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSongBinding.inflate(inflater)

        val adapter = SongAdapter(listSongs)

        binding.rcvSong.adapter = adapter
        binding.rcvSong.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        return binding.root
    }

}