package com.eunma.sinsamguide.data.notice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eunma.sinsamguide.databinding.ActivityNoticeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoticeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        RetrofitService.noticeApi.getNotices().enqueue(object : Callback<List<Notice>> {
            override fun onResponse(call: Call<List<Notice>>, response: Response<List<Notice>>) {
                if (response.isSuccessful) {
                    val notices = response.body()
                    // 여기서 notices를 RecyclerView에 표시합니다.
                    if (notices != null) {
                        setupRecyclerView(notices)
                    }
                }
            }

            override fun onFailure(call: Call<List<Notice>>, t: Throwable) {
                // 네트워크 요청이 실패한 경우에 대한 처리를 여기서 합니다.
            }
        })
    }

    private fun setupRecyclerView(notices: List<Notice>) {
        binding.noticeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.noticeRecyclerView.adapter = NoticeAdapter(notices)
    }
}