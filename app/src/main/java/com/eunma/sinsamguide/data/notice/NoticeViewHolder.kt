package com.eunma.sinsamguide.data.notice

import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.databinding.NoticeItemBinding

class NoticeViewHolder(private val binding: NoticeItemBinding) : RecyclerView.ViewHolder(binding.root) {
    private var isContentVisible = false

    fun bind(notice: Notice) {
        binding.noticeTitle.text = notice.title
        binding.noticeDate.text = notice.date
        binding.noticeContent.text = notice.content
        binding.noticeContent.visibility = View.GONE // 초기에는 내용을 숨김

        binding.root.setOnClickListener {
            isContentVisible = !isContentVisible // 클릭 시 마다 visibility 상태를 변경
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
            binding.noticeContent.visibility = if (isContentVisible) View.VISIBLE else View.GONE
        }
    }
}