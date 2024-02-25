package com.example.myappdemo

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import com.example.myappdemo.recyclerview.MainActivity4
import com.example.myappdemo.thread.ThreadActivity

class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn2 :Button = findViewById(R.id.btn2)
        val btn3 :Button = findViewById(R.id.btn3)
        val btn4 :Button = findViewById(R.id.btn4)
        val btn5 :Button = findViewById(R.id.btn5)
        val btn6 :Button = findViewById(R.id.btn6)
        val btn7 :Button = findViewById(R.id.btn7)
        val btn8 :Button = findViewById(R.id.btn8)
        btn2.setOnClickListener {
            val i = Intent(this,MainActivity2::class.java)
            startActivity(i)
        }
        btn3.setOnClickListener {
            val i = Intent(this,MainActivity3::class.java)
            startActivity(i)
        }
        btn4.setOnClickListener {
            val i = Intent(this,MainActivity4::class.java)
            startActivity(i)
        }
        btn5.setOnClickListener {
            val i = Intent(this,LinearLayoutActivity::class.java)
            startActivity(i)
        }
        btn6.setOnClickListener {
            val i = Intent(this,MusicActivity::class.java)
            startActivity(i)
        }
        btn7.setOnClickListener {
            val i = Intent(this,ThreadActivity::class.java)
            startActivity(i)
        }
        btn8.setOnClickListener {
            val i = Intent(this,TransactionDetailsActivity::class.java)
            startActivity(i)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart()","onStart")
        Toast.makeText(this,"onStart activity Main",Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("onRestart()","onRestart")
        Toast.makeText(this,"onRestart activity Main",Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume()","onResume")
        Toast.makeText(this,"onResume activity Main",Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Log.d("onPause()","onPause")
        Toast.makeText(this,"onPause activity Main",Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Log.d("onStop()","onStop")
        Toast.makeText(this,"onStop activity Main",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("onDestroy()","onDestroy")
        Toast.makeText(this,"onDestroy activity Main",Toast.LENGTH_SHORT).show()
    }
}

