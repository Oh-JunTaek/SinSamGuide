package com.eunma.sinsamguide.data.notice

import retrofit2.Call
import retrofit2.http.GET

interface NoticeApi {
    @GET("notice.json")
    fun getNotices(): Call<List<Notice>>
}
