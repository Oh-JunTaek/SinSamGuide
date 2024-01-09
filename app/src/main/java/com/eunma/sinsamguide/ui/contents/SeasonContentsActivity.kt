package com.eunma.sinsamguide.ui.contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivityMainContentsBinding
import com.eunma.sinsamguide.databinding.ActivitySeasonContentsBinding

class SeasonContentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeasonContentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeasonContentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("시즌 컨텐츠")

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.seasonRecyclerView.layoutManager = gridLayoutManager
        binding.seasonRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16))

        val dataList: List<ContentsData> = listOf(
            ContentsData(R.drawable.baekma, "백마연진 지전",
                getString(R.string.detail_baekma),
                ContentsViewPagerImages.values().filter { it.name.startsWith("BAEKMA") }
                    .map { it.imageResId }
            ),
            ContentsData(R.drawable.red_cliffs, "적벽 대전",
                getString(R.string.detail_red_cliffs),
                ContentsViewPagerImages.values().filter { it.name.startsWith("RED_CLIFFS") }
                    .map { it.imageResId }
            ),
            ContentsData(R.drawable.hanjung, "한중 전쟁",
                getString(R.string.detail_hanjung),
                ContentsViewPagerImages.values().filter { it.name.startsWith("HANJUNG") }
                    .map { it.imageResId }
            ),
        )



        binding.seasonRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}