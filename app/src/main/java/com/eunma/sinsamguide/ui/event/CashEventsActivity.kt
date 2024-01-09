package com.eunma.sinsamguide.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivityCashEventsBinding
import com.eunma.sinsamguide.ui.contents.ContentsData
import com.eunma.sinsamguide.ui.contents.ContentsViewPagerImages
import com.eunma.sinsamguide.ui.contents.GridSpacingItemDecoration
import com.eunma.sinsamguide.ui.contents.MyRecyclerViewAdapter

class CashEventsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCashEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCashEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("소비 이벤트")

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.casheventsRecyclerView.layoutManager = gridLayoutManager
        binding.casheventsRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16))

        val dataList: List<ContentsData> = listOf(
            ContentsData(R.drawable.baekma, "군단 박매소",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
            ContentsData(R.drawable.red_cliffs, "한정 교환",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
            ContentsData(R.drawable.hanjung, "보물 탐색",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
            ContentsData(R.drawable.hanjung, "보물 찾기",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
            ContentsData(R.drawable.hanjung, "정통 인화",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
        )

        binding.casheventsRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}