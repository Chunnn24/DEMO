package com.example.myappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappdemo.adapter.ContentAdapter
import com.example.myappdemo.databinding.ActivityRelativeLayoutBinding
import com.example.myappdemo.model.Content

class RelativeLayoutActivity : AppCompatActivity() {
    private lateinit var binding:ActivityRelativeLayoutBinding
    private lateinit var adapter: ContentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRelativeLayoutBinding.inflate(layoutInflater)
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
            val i = Intent(this,ConstraintLayoutActivity::class.java)
            startActivityForResult(i,50)
        }

        binding.ivBack.setOnClickListener {
            setResult(Tags.BACK_LINEARLAYOUT)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 50){
            when(resultCode){
                Tags.BACK_RELATIVELAYOUT ->{
                    Toast.makeText(this,"Back to Activity RelativeLayout success",Toast.LENGTH_SHORT).show()
                }
                RESULT_OK ->{
                    setResult(RESULT_OK)
                    finish()
                }
            }
        }
    }
}