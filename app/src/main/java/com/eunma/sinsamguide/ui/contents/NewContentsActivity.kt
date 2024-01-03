package com.eunma.sinsamguide.ui.contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivityNewContentsBinding

class NewContentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewContentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewContentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setTitle("신규 컨텐츠")

        val gridLayoutManager = GridLayoutManager(this, 2)
        binding.newRecyclerView.layoutManager = gridLayoutManager
        binding.newRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, 16))

        val dataList: List<ContentsData> = listOf(
            ContentsData(R.drawable.mewu, "묘우 탈보",getString(R.string.detail_mewu)),
            ContentsData(R.drawable.ujaek, "유적 정봉",getString(R.string.detail_ujaek))

        )

        binding.newRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}