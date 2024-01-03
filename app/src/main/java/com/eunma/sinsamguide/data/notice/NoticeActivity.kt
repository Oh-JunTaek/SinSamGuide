package com.eunma.sinsamguide.data.notice

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.databinding.ActivityNoticeBinding
import com.google.firebase.firestore.FirebaseFirestore

class NoticeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNoticeBinding
    private val adapter = NoticeAdapter(emptyList())
    private val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoticeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("공지사항")
        binding.noticeRecyclerView.addItemDecoration(VerticalSpaceItemDecoration(30))
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
    class VerticalSpaceItemDecoration(private val verticalSpaceHeight: Int) : RecyclerView.ItemDecoration() {

        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            outRect.bottom = verticalSpaceHeight
        }
    }
}
