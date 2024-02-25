package com.example.myappdemo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myappdemo.databinding.ItemContentGoldBinding
import com.example.myappdemo.databinding.ItemContentTvBinding
import com.example.myappdemo.databinding.ItemTitleBinding
import com.example.myappdemo.model.ListItem

class MultipleAdapter(
    private val mList: List<ListItem>,
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val TYPE_ITEM_1 = 1
        const val TYPE_ITEM_2 = 2
        const val TYPE_ITEM_3 = 3
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            TYPE_ITEM_1 -> TitleViewHolder(ItemTitleBinding.inflate(LayoutInflater.from(parent.context)))
            TYPE_ITEM_2 -> DetailsContentHolder(
                ItemContentTvBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    )
                )
            )

            TYPE_ITEM_3 -> ContentGoldHolder(
                ItemContentGoldBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    )
                )
            )

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int = mList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = mList[position]
        when(item){
            is ListItem.DetailsContent -> (holder as DetailsContentHolder).bind(item)
            is ListItem.DetailsContentGold -> (holder as ContentGoldHolder).bind(item)
            is ListItem.Title -> (holder as TitleViewHolder).bind(item)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (mList[position]) {
            is ListItem.Title -> TYPE_ITEM_1
            is ListItem.DetailsContent -> TYPE_ITEM_2
            is ListItem.DetailsContentGold -> TYPE_ITEM_3
        }
    }

    inner class TitleViewHolder(private val binding: ItemTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(title: ListItem.Title) {
            binding.tvTitle.text = title.tvTitle
        }
    }

    inner class DetailsContentHolder(private val binding: ItemContentTvBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(content: ListItem.DetailsContent) {
            binding.tvContent.text = content.tvContent
            binding.tvValue.text = content.tvValue
        }
    }

    inner class ContentGoldHolder(private val binding: ItemContentGoldBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(content: ListItem.DetailsContentGold) {
            binding.tvValueGold.text = content.tvValueGold
            binding.tvContent.text = content.tvContent
        }
    }

}