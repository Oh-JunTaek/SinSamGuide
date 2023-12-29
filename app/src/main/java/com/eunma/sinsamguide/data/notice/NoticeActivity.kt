package com.eunma.sinsamguide.data.notice

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eunma.sinsamguide.databinding.ActivityNoticeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoticeBinding
    private val adapter = NoticeAdapter(emptyList())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.noticeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.noticeRecyclerView.adapter = adapter

        RetrofitService.noticeApi.getNotices().enqueue(object : Callback<List<Notice>> {
            override fun onResponse(call: Call<List<Notice>>, response: Response<List<Notice>>) {
                if (response.isSuccessful) {
                    val notices = response.body()
                    // 여기서 notices를 RecyclerView에 표시합니다.
                    if (notices != null) {
                        if (notices.isNotEmpty()) {
                            setupRecyclerView(notices)
                        } else {
                            Toast.makeText(this@NoticeActivity, "공지사항이 없습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<Notice>>, t: Throwable) {
                Toast.makeText(this@NoticeActivity, "데이터를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
                this@NoticeActivity.finish()
            }
        })
    }

    private fun setupRecyclerView(notices: List<Notice>) {
        binding.noticeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.noticeRecyclerView.adapter = NoticeAdapter(notices)
    }
    private fun updateAdapterData(notices: List<Notice>) {
        adapter.updateData(notices) // 구현 필요
    }
}