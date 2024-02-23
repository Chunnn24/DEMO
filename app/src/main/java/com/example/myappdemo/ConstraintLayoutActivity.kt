package com.example.myappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappdemo.adapter.ContentAdapter
import com.example.myappdemo.databinding.ActivityConstraintLayoutBinding
import com.example.myappdemo.model.Content

class ConstraintLayoutActivity : AppCompatActivity() {
    private lateinit var binding:ActivityConstraintLayoutBinding
    private lateinit var adapter : ContentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConstraintLayoutBinding.inflate(layoutInflater)
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
        binding.rcvScroll.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL,false)

        binding.btnBottom.setOnClickListener {
            val i = Intent(this,BackToActivity::class.java)
            startActivityForResult(i,10)
        }
        binding.ivBack.setOnClickListener {
            setResult(Tags.BACK_RELATIVELAYOUT)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 10){
            if (resultCode == RESULT_OK){
                setResult(RESULT_OK)
                finish()
            }
        }
    }
}