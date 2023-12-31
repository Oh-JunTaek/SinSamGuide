package com.eunma.sinsamguide.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivityMainEventsBinding
import com.eunma.sinsamguide.ui.contents.ContentsData
import com.eunma.sinsamguide.ui.contents.ContentsViewPagerImages
import com.eunma.sinsamguide.ui.contents.GridSpacingItemDecoration
import com.eunma.sinsamguide.ui.contents.MyRecyclerViewAdapter

class MainEventsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("메인 이벤트")

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.maineventsRecyclerView.layoutManager = gridLayoutManager
        binding.maineventsRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16))

        val dataList: List<ContentsData> = listOf(
            ContentsData(R.drawable.baekma, "계절",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
            ContentsData(R.drawable.red_cliffs, "비적 소탕",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
            ContentsData(R.drawable.hanjung, "결사 항전",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
        )

        binding.maineventsRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}