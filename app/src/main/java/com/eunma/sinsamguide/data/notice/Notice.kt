package com.eunma.sinsamguide.data.notice

data class Notice(
    @JvmField val type: String = "",
    @JvmField val title: String = "",
    @JvmField val date: String = "",
    @JvmField val content: String = ""
)