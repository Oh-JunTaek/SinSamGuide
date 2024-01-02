package com.eunma.sinsamguide.ui.encyclopedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eunma.sinsamguide.databinding.ActivityEncyclopediaMainBinding


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
        viewAdapter = EncyclopediaAdapter(items)

        binding.recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}
