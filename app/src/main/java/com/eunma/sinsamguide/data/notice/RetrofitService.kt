package com.eunma.sinsamguide.data.notice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://your-server.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val noticeApi: NoticeApi = retrofit.create(NoticeApi::class.java)
}
