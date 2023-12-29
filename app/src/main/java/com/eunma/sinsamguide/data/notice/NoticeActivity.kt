package com.eunma.sinsamguide.data.notice

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eunma.sinsamguide.databinding.ActivityNoticeBinding
import com.google.firebase.firestore.FirebaseFirestore
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NoticeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoticeBinding
    private val adapter = NoticeAdapter(emptyList())
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadNoticesFromFirestore()

        binding.noticeRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.noticeRecyclerView.adapter = adapter
    }

    private fun setupRecyclerView(notices: List<Notice>) {
        adapter.updateData(notices)
    }
    private fun updateAdapterData(notices: List<Notice>) {
        adapter.updateData(notices)
    }
    private fun loadNoticesFromFirestore() {
        db.collection("notices")
            .get()
            .addOnSuccessListener { documents ->
                val noticesList = documents.map { document ->
                    document.toObject(Notice::class.java)
                }
                updateAdapterData(noticesList)
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "데이터를 불러오는데 실패했습니다.", Toast.LENGTH_SHORT).show()
                Log.e("NoticeActivity", "Error getting documents: ", exception)
            }
    }
}
