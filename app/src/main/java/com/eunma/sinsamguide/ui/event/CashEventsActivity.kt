package com.eunma.sinsamguide.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivityCashEventsBinding
import com.eunma.sinsamguide.ui.contents.ContentsData
import com.eunma.sinsamguide.ui.contents.GridSpacingItemDecoration
import com.eunma.sinsamguide.ui.contents.MyRecyclerViewAdapter

class CashEventsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCashEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCashEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.casheventsRecyclerView.layoutManager = gridLayoutManager
        binding.casheventsRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16))

        val dataList: List<ContentsData> = listOf(
            ContentsData(R.drawable.baekma, "군단 박매소", "백마연진 지전에 대한 설명"),
            ContentsData(R.drawable.red_cliffs, "한정 교환", "적벽 대전에 대한 설명"),
            ContentsData(R.drawable.hanjung, "보물 탐색", "한중 전쟁에 대한 설명"),
            ContentsData(R.drawable.hanjung, "보물 찾기", "한중 전쟁에 대한 설명"),
            ContentsData(R.drawable.hanjung, "정통 인화", "한중 전쟁에 대한 설명")
        )

        binding.casheventsRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}