package com.example.myappdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    lateinit var btnCook : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnCook = findViewById(R.id.button)

        btnCook.setOnClickListener {
            val i = Intent(this,TemplateActivity::class.java)
            startActivity(i)
        }
    }
}