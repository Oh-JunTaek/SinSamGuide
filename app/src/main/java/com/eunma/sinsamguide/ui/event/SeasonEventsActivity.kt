package com.eunma.sinsamguide.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivitySeasonEventsBinding
import com.eunma.sinsamguide.ui.contents.ContentsData
import com.eunma.sinsamguide.ui.contents.GridSpacingItemDecoration
import com.eunma.sinsamguide.ui.contents.MyRecyclerViewAdapter

class SeasonEventsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySeasonEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySeasonEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.seasoneventsRecyclerView.layoutManager = gridLayoutManager
        binding.seasoneventsRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16))

        val dataList: List<ContentsData> = listOf(
            ContentsData(R.drawable.baekma, "백마연진 지전",""),
            ContentsData(R.drawable.red_cliffs, "적벽 대전",""),
            ContentsData(R.drawable.hanjung, "한중 전쟁","")
        )

        binding.seasoneventsRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}