package com.eunma.sinsamguide.ui.contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivityMainContentsBinding

class MainContentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainContentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainContentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("메인 컨텐츠")

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.myRecyclerView.layoutManager = gridLayoutManager
        binding.myRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16))

        val dataList: List<ContentsData> = listOf(
            ContentsData(
                R.drawable.anmoon,
                "안문 전투 - 군웅토동",
                getString(R.string.detail_anmoon),
                ContentsViewPagerImages.values().filter { it.name.startsWith("ANMOON") }.map { it.imageResId }
            ),
            ContentsData(R.drawable.namman, "남만 침입",getString(R.string.detail_namman), listOf()),
            ContentsData(R.drawable.janngan, "장안 쟁탈전",getString(R.string.detail_jangan), listOf()),
            ContentsData(R.drawable.gundan, "군단 전투",getString(R.string.detail_gundan), listOf())
        )

        binding.myRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}