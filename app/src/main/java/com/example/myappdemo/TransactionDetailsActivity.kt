package com.example.myappdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myappdemo.adapter.MultipleAdapter
import com.example.myappdemo.databinding.ActivityMain5Binding
import com.example.myappdemo.model.ListItem

class TransactionDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMain5Binding
    private lateinit var adapter : MultipleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val list = arrayListOf<ListItem>(
            ListItem.Title("Thông tin chung"),
            ListItem.DetailsContent("Mã giao dịch","123456"),
            ListItem.DetailsContent("Kênh giao dịch","OMNI MB"),
            ListItem.DetailsContentGold("Trạng thái giao dịch","Thành công"),
            ListItem.DetailsContent("Người thực hiện","CHUNG CHAN CHAT"),
            ListItem.Title("Thông tin trích tuyến"),
            ListItem.DetailsContent("Số tài khoản","123456"),
            ListItem.DetailsContent("Loại tiền","123456"),
            ListItem.DetailsContent("Chi nhánh PDG","Eximbank - PGD bến thành"),
            ListItem.Title("Thông tin thụ hưởng"),
            ListItem.DetailsContent("Công ty chứng khoán","CTTP chứng khoán\n Rồng Việt VDSC"),
            ListItem.DetailsContent("Dịch vụ","Nộp tiền CT chứng khoán\nRồng Việt HCM"),
            ListItem.DetailsContent("Số tài khoản","30062001"),
            ListItem.DetailsContent("Loại tiền:","VND"),
            ListItem.DetailsContent("Chi nhánh/PDG","Eximbank - PDG Bến Tre"),
            ListItem.DetailsContent("Mã chứng khoán","VN123456"),
            ListItem.DetailsContent("Tên khác hàng","LE TUAN CHUNG"),
            ListItem.Title("Thông tin giao dịch"),
            ListItem.DetailsContent("Loại tiền:","VND"),
            ListItem.DetailsContentGold("Số tiền","20,000,000 NVD"),
            ListItem.DetailsContent("Nội dung","Nop tien cho khach hang LE\n TUAN CHUNG số tiền 60,000,000"),
            )

        adapter = MultipleAdapter(list)
        binding.recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.recyclerView.adapter = adapter
    }
}