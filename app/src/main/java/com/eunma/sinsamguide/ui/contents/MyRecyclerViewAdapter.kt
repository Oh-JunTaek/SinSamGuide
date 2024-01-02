package com.eunma.sinsamguide.ui.contents

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.databinding.CardviewLayoutBinding

class MyRecyclerViewAdapter(private val dataList: List<ContentsData>) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    // ViewHolder 클래스를 내부 클래스(inner class)로 변경하여 아이템 클릭 이벤트를 처리합니다.
    inner class ViewHolder(val binding: CardviewLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val item = dataList[position]
                    // 새로운 액티비티를 시작하고, 아이템 데이터를 인텐트에 담아 전달합니다.
                    val intent = Intent(binding.root.context, DetailActivity::class.java).apply {
                        putExtra("item", item)
                    }
                    binding.root.context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CardviewLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = dataList[position]
        holder.binding.imageView.setImageResource(data.imageResId)
        holder.binding.textView.text = data.text
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}
