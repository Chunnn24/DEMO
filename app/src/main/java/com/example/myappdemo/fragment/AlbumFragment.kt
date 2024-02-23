package com.example.myappdemo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myappdemo.R
import com.example.myappdemo.databinding.FragmentAlbumBinding
import com.example.myappdemo.databinding.FragmentSongBinding


class AlbumFragment : Fragment() {

    private lateinit var binding: FragmentAlbumBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlbumBinding.inflate(inflater)
        return binding.root
    }
}