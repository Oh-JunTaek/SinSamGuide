package com.eunma.sinsamguide.ui.contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunma.sinsamguide.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // 인텐트를 통해 아이템 데이터를 받습니다.
        val item = intent.getParcelableExtra<ContentsData>("item")
        // 여기서 item은 전달받은 아이템의 데이터입니다. 이를 화면에 표시하면 됩니다.
    }
}