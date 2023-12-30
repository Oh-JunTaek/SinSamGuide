package com.eunma.sinsamguide.ui.contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.eunma.sinsamguide.R
import com.eunma.sinsamguide.databinding.ActivityMainContentsBinding

class MainContentsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainContentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainContentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataList: List<ContentsData> = listOf(
            ContentsData(R.drawable.anmoon, "안문 전투"),
            ContentsData(R.drawable.namman, "남만 침입"),
            ContentsData(R.drawable.janngan, "장안 쟁탈전")
        )

        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.myRecyclerView.adapter = MyRecyclerViewAdapter(dataList)
    }
}