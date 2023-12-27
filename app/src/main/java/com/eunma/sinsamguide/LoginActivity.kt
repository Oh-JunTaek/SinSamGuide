package com.eunma.sinsamguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.eunma.sinsamguide.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.googleSignInButton.setOnClickListener {
            // 구글 로그인 기능 실행
        }

        binding.guestSignInButton.setOnClickListener {
            // 게스트 로그인 기능 실행
        }
    }
}
