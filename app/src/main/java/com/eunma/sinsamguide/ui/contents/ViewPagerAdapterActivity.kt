package com.eunma.sinsamguide.ui.contents

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.R

class ViewPagerAdapterActivity(private val imageResIdList: List<Int>) :
    RecyclerView.Adapter<ViewPagerAdapterActivity.ViewHolder>() {

    inner class ViewHolder(val imageView: ImageView) : RecyclerView.ViewHolder(imageView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val imageView = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_pager_item, parent, false) as ImageView
        return ViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(imageResIdList[position])
    }

    override fun getItemCount(): Int {
        return imageResIdList.size
    }
}