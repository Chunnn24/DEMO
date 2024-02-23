package com.example.myappdemo.thread

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myappdemo.R
import com.example.myappdemo.databinding.ActivityCoroutineBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import kotlin.coroutines.CoroutineContext

class CoroutineActivity : AppCompatActivity(),CoroutineScope {
    private lateinit var binding: ActivityCoroutineBinding
    private lateinit var job : Job
    private lateinit var job2 : Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoroutineBinding.inflate(layoutInflater)
        setContentView(binding.root)

        job = Job()

        binding.btnDownload.setOnClickListener {
//            GlobalScope.launch {
//                val bitmap = downloadFileWithCoroutine()
//                withContext(Dispatchers.Main){
//                    binding.ivAvatar.setImageBitmap(bitmap)
//                }
//            }
            launch(Dispatchers.IO) {
                val bitmap = downloadFileWithCoroutine()
                withContext(Dispatchers.Main){
                    binding.ivAvatar.setImageBitmap(bitmap)
                }
            }
        }
//        val friends = async(Dispatchers.IO) {
//            getAllFriends()
//        }
//        val messages = async(Dispatchers.IO) {
//            getAllMessages()
//        }
//        launch {
//            // sử dụng await() để user có giá trị khi cả 2 thực hiện xong
//            val user = friends.await() + messages.await()
//            Log.d("Chungcc","user:$user")
//        }

        main()
    }
    fun main() {
        // Tạo và chạy một coroutine
        val job = GlobalScope.launch {
            delay(1000L) // Giả định thực hiện một công việc mất thời gian
            Log.d("ABC","Coroutine đã hoàn thành")
        }

        Log.d("BCD","Đang chờ coroutine hoàn thành...")
        Thread.sleep(2000L) // Chờ 2 giây để coroutine hoàn thành
        Log.d("DCE","Chương trình kết thúc")
    }
    suspend fun downloadFileWithCoroutine() : Bitmap{
        val url = URL("https://media1.nguoiduatin.vn/media/nguyen-ngoc-hoai-thanh/2023/10/20/vu-nguoi-mau-ngoc-trinh-bi-bat-bai-hoc-canh-tinh-cho-su-bat-chap.png")
        val connection = url.openConnection()
        val inputConnection = connection.getInputStream()
        return BitmapFactory.decodeStream(inputConnection)
    }

    suspend fun getAllFriends():String{
        return "this is list friends"
    }

    suspend fun getAllMessages() : String{
        return "this is message list for user"
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
}