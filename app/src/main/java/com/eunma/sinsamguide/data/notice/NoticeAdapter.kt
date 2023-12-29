package com.eunma.sinsamguide.data.notice

import android.graphics.Color
import android.graphics.Rect
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
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

    class NoticeViewHolder(private val binding: NoticeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(notice: Notice) {
            binding.noticeType.text = notice.type
            binding.noticeTitle.text = notice.title
            binding.noticeDate.text = notice.date
            binding.noticeContent.text = notice.content

            // 공지사항 타입에 따라 색 변경
            if (notice.type == "버그수정") {
                binding.noticeType.setTextColor(Color.RED)
            } else {
                binding.noticeType.setTextColor(Color.BLUE)
            }

            itemView.setOnClickListener {
                TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
                if (binding.noticeContent.visibility == View.GONE) {
                    binding.noticeContent.visibility = View.VISIBLE
                } else {
                    binding.noticeContent.visibility = View.GONE
                }
            }
        }
    }
}