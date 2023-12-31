package com.eunma.sinsamguide.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivitySeasonEventsBinding
import com.eunma.sinsamguide.ui.contents.ContentsData
import com.eunma.sinsamguide.ui.contents.ContentsViewPagerImages
import com.eunma.sinsamguide.ui.contents.GridSpacingItemDecoration
import com.eunma.sinsamguide.ui.contents.MyRecyclerViewAdapter

class SeasonEventsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeasonEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeasonEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("시즌 이벤트")

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.seasoneventsRecyclerView.layoutManager = gridLayoutManager
        binding.seasoneventsRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16))

        val dataList: List<ContentsData> = listOf(
            ContentsData(R.drawable.red_cliffs, "왕후 병기",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
            ContentsData(R.drawable.hanjung, "호붕 환우",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
        )

        binding.seasoneventsRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}