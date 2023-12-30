package com.eunma.sinsamguide.ui.contents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.databinding.CardviewLayoutBinding

class MyRecyclerViewAdapter(private val dataList: List<ContentsData>) : RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(val binding: CardviewLayoutBinding) : RecyclerView.ViewHolder(binding.root)

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