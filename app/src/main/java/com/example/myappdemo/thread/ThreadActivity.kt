package com.example.myappdemo.thread

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.Toast
import androidx.annotation.RestrictTo.Scope
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.myappdemo.databinding.ActivityThreadBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class ThreadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThreadBinding
    private lateinit var bitmap: Bitmap
    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
//            if (msg.what == UPDATE_IMAGE) {
//                binding.ivAvatar.setImageBitmap(bitmap)
//            }
            val bitmap = msg.obj as Bitmap
            binding.ivAvatar.setImageBitmap(bitmap)

        }
    }
    private val UPDATE_IMAGE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDownload.setOnClickListener {
//            GlobalScope.launch {
//                val bitmap = downloadFileWithCoroutine()
//                binding.ivAvatar.setImageBitmap(bitmap)
//            }
//            downloadImage()

            DownloadFile().execute("https://media1.nguoiduatin.vn/media/nguyen-ngoc-hoai-thanh/2023/10/20/vu-nguoi-mau-ngoc-trinh-bi-bat-bai-hoc-canh-tinh-cho-su-bat-chap.png")
        }

        binding.btnNext.setOnClickListener {
            val i = Intent(this,CoroutineActivity::class.java)
            startActivity(i)
        }


    }

    inner class DownloadFile:AsyncTask<String,Void,Bitmap>(){

        override fun onPreExecute() {
            super.onPreExecute()
            Toast.makeText(applicationContext,"Start Downloading!",Toast.LENGTH_SHORT).show()
        }

        override fun doInBackground(vararg params: String?): Bitmap {
            val link = params[0]
            val url = URL(link)
            val connection = url.openConnection()
            val inputStream = connection.getInputStream()
           return BitmapFactory.decodeStream(inputStream)
        }

        override fun onProgressUpdate(vararg values: Void?) {
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: Bitmap?) {
            super.onPostExecute(result)
            binding.ivAvatar.setImageBitmap(result)
        }
    }

    suspend fun downloadFileWithCoroutine() : Bitmap{
        val url = URL("https://media1.nguoiduatin.vn/media/nguyen-ngoc-hoai-thanh/2023/10/20/vu-nguoi-mau-ngoc-trinh-bi-bat-bai-hoc-canh-tinh-cho-su-bat-chap.png")
        val connection = url.openConnection()
        val inputConnection = connection.getInputStream()
       return BitmapFactory.decodeStream(inputConnection)

    }

    fun downloadImage() {
        Thread {
//            for (i in 1 .. 10){
//                Log.d("Chung","Thread run : $i")
//                Thread.sleep(1000)
//            }
            val url = URL("https://media1.nguoiduatin.vn/media/nguyen-ngoc-hoai-thanh/2023/10/20/vu-nguoi-mau-ngoc-trinh-bi-bat-bai-hoc-canh-tinh-cho-su-bat-chap.png")
            val connection = url.openConnection()
            val inputConnection = connection.getInputStream()
            bitmap = BitmapFactory.decodeStream(inputConnection)

//            handler.sendEmptyMessage(UPDATE_IMAGE)
            var smg = Message()
            smg.arg1 = 10
            smg.arg2 = 20
            smg.obj = bitmap
            handler.sendMessage(smg)

//            runOnUiThread {
//                binding.ivAvatar.setImageBitmap(bitmap)
//            }
//            binding.ivAvatar.post {
//                binding.ivAvatar.setImageBitmap(bitmap)
//            }
        }.start()
    }
}