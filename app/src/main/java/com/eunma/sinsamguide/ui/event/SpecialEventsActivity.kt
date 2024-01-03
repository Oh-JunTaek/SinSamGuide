package com.eunma.sinsamguide.ui.event

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivitySpecialEventsBinding
import com.eunma.sinsamguide.ui.contents.ContentsData
import com.eunma.sinsamguide.ui.contents.GridSpacingItemDecoration
import com.eunma.sinsamguide.ui.contents.MyRecyclerViewAdapter

class SpecialEventsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySpecialEventsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySpecialEventsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("특별 이벤트")

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.specialeventsRecyclerView.layoutManager = gridLayoutManager
        binding.specialeventsRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16))

        val dataList: List<ContentsData> = listOf(
            ContentsData(R.drawable.baekma, "카페 이벤트",""),
            ContentsData(R.drawable.red_cliffs, "적벽 대전",""),
            ContentsData(R.drawable.hanjung, "한중 전쟁","")
        )

        binding.specialeventsRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}