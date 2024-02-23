package com.example.myappdemo.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.myappdemo.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity(),OnPersonItemClick {

    private lateinit var binding: ActivityMain4Binding
    private lateinit var adapter : AdapterPerson
    private val contact = arrayListOf(
        Person(name = "ChungChanChat", address = "Thanh Hóa"),
        Person(name = "ChungChanChat1", address = "Thanh Hóa1"),
        Person(name = "ChungChanChat2", address = "Thanh Hóa2"),
        Person(name = "ChungChanChat3", address = "Thanh Hóa3"),
        Person(name = "ChungChanChat4", address = "Thanh Hóa4"),
        Person(name = "ChungChanChat5", address = "Thanh Hóa5")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = AdapterPerson(contact,this)

        binding.rcvData.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
//        binding.rcvData.layoutManager = GridLayoutManager(this,2)
//        binding.rcvData.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL)
        binding.rcvData.adapter = adapter
    }

    override fun onClick(position: Int) {
        Log.d("TAG", "onClick: $position")
    }

    override fun onLongClick(position: Int) {
        Log.d("TAG", "onLongClick: $position")
    }
}