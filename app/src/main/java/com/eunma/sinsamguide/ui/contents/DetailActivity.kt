package com.eunma.sinsamguide.ui.contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunma.sinsamguide.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 뷰 바인딩을 사용하여 레이아웃을 inflate 합니다.
        val binding = ActivityDetailBinding.inflate(layoutInflater)

        // 인텐트를 통해 아이템 데이터를 받습니다.
        val item = intent.getParcelableExtra<ContentsData>("item")

        val imageList = intent.getIntegerArrayListExtra("imageList")
        if (imageList != null) {
            binding.viewPager.adapter = ViewPagerAdapterActivity(imageList)
        }

        // 전달받은 아이템의 데이터를 화면에 표시합니다.
        item?.let {
            binding.contentTitle.text = it.text
            binding.contentDetail.text = it.detail
        }


        setContentView(binding.root)
    }
}
