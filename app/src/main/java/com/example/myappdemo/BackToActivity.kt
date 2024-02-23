package com.example.myappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myappdemo.databinding.ActivityBackToBinding

class BackToActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBackToBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBackToBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener {
            finish()
        }
        binding.btnBack.setOnClickListener {
            setResult(RESULT_OK)
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}