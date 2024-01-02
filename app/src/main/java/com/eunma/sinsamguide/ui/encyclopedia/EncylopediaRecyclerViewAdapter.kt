package com.eunma.sinsamguide.ui.encyclopedia

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.databinding.ItemEncyclopediaBinding

class EncyclopediaAdapter(
    private val items: List<EncyclopediaItem>,
    private val itemClickListener: (EncyclopediaItem) -> Unit
) : RecyclerView.Adapter<EncyclopediaAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemEncyclopediaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemEncyclopediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding).apply {
            itemView.setOnClickListener {
                val position = adapterPosition.takeIf { it != RecyclerView.NO_POSITION }
                    ?: return@setOnClickListener
                itemClickListener.invoke(items[position])
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.title.text = item.title
        holder.binding.content.text = item.content
    }

    override fun getItemCount() = items.size
}
