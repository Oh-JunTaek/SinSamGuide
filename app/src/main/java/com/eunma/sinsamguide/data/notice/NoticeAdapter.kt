package com.eunma.sinsamguide.data.notice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.databinding.NoticeItemBinding

class NoticeAdapter(private var noticeList: List<Notice>) : RecyclerView.Adapter<NoticeAdapter.NoticeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoticeViewHolder {
        val binding = NoticeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoticeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoticeViewHolder, position: Int) {
        val notice = noticeList[position]
        holder.bind(notice)
    }

    override fun getItemCount(): Int {
        return noticeList.size
    }

    fun updateData(newNotices: List<Notice>) {
        noticeList = newNotices
        notifyDataSetChanged()
    }

    class NoticeViewHolder(private val binding: NoticeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(notice: Notice) {
            binding.noticeTitle.text = notice.title
            binding.noticeDate.text = notice.date
            binding.noticeContent.text = notice.content
        }
    }
}