package com.eunma.sinsamguide.data.notice

import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.databinding.NoticeItemBinding

class NoticeViewHolder(private val binding: NoticeItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private var isContentVisible = false

    init {
        binding.root.setOnClickListener {
            isContentVisible = !isContentVisible
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
            binding.noticeContent.visibility = if (isContentVisible) View.VISIBLE else View.GONE
        }
    }

    fun bind(notice: Notice) {
        binding.noticeType.text = notice.type
        binding.noticeTitle.text = notice.title
        binding.noticeDate.text = notice.date
        binding.noticeContent.text = notice.content
    }
}
