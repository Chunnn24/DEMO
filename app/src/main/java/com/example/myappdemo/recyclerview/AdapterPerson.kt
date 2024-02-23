package com.example.myappdemo.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myappdemo.databinding.ItemContactBinding

class AdapterPerson(private val mList: List<Person>,
    private val callback:OnPersonItemClick):RecyclerView.Adapter<AdapterPerson.ViewHolder>() {

    inner class ViewHolder(private val binding:ItemContactBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(person: Person){
            binding.tvName.text = person.name
            binding.tvAddress.text = person.address
            binding.ivAvatar.setImageResource(person.imgAvatar!!)

//            binding.root.setOnClickListener {
//                Toast.makeText(binding.root.context,person.name,Toast.LENGTH_SHORT).show()
//            }
            binding.ivAvatar.setOnClickListener {
                callback.onClick(adapterPosition)
            }
            binding.ivAvatar.setOnClickListener {
                callback.onLongClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(binding = ItemContactBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(mList[position])
    }
}