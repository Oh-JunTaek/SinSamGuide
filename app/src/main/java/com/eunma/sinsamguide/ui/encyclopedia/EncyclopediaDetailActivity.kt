package com.eunma.sinsamguide.ui.encyclopedia

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eunma.sinsamguide.databinding.ActivityEncyclopediaDetailBinding

class EncyclopediaDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEncyclopediaDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEncyclopediaDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 인텐트로부터 전달받은 title과 content를 가져옴
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")

        // 가져온 title과 content를 레이아웃에 표시
        binding.title.text = title
        binding.content.text = content
    }
}
