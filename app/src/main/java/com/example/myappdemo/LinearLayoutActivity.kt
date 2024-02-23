package com.example.myappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappdemo.adapter.ContentAdapter
import com.example.myappdemo.databinding.ActivityLinearLayoutBinding
import com.example.myappdemo.model.Content
import com.example.myappdemo.model.Song

class LinearLayoutActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLinearLayoutBinding
    private lateinit var adapter : ContentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLinearLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val listContent = arrayListOf(
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung"),
            Content("Hello","Chung")
        )
        adapter = ContentAdapter(listContent)

        binding.rcvScroll.adapter = adapter
        binding.rcvScroll.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        binding.btnBottom.setOnClickListener {
            val i = Intent(this,RelativeLayoutActivity::class.java)
            startActivityForResult(i,100)
        }
        binding.ivBack.setOnClickListener {
            finish()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100){
            when(resultCode){
                Tags.BACK_LINEARLAYOUT -> {
                    Toast.makeText(this,"Back to Activity LinearLayout success", Toast.LENGTH_SHORT).show()
                }

                RESULT_OK -> {
                    Toast.makeText(this,"Back to Home success",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}