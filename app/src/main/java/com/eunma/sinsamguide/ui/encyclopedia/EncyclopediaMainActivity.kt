package com.eunma.sinsamguide.ui.encyclopedia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.databinding.ActivityEncyclopediaMainBinding
import com.eunma.sinsamguide.ui.home.HomeFragment


class EncyclopediaMainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEncyclopediaMainBinding
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEncyclopediaMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 샘플 데이터 생성
        val items = List(100) { EncyclopediaItem("Item #$it", "This is content #$it") }

        viewManager = LinearLayoutManager(this)
        val viewAdapter = EncyclopediaAdapter(items) { item ->
            val intent = Intent(this, EncyclopediaDetailActivity::class.java).apply {
                putExtra("title", item.title)
                putExtra("content", item.content)
            }
            startActivity(intent)
        }

        // 메인으로 가는 버튼 클릭 이벤트
        binding.goBackButton.setOnClickListener {
            finish()
        }


        // 도움말 버튼 클릭 이벤트
        binding.helpButton.setOnClickListener {
            Toast.makeText(this, "미구현입니다.", Toast.LENGTH_SHORT).show()
        }


        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
