package com.eunma.sinsamguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
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
            AlertDialog.Builder(this)
                .setTitle("게스트 로그인")
                .setMessage("게스트 로그인 시 알림 및 게시판 등의 기능을 사용할 수 없습니다. 계속 진행하시겠습니까?")
                .setPositiveButton("네") { _, _ ->
                    moveToMainActivity()
                }
                .setNegativeButton("아니오", null)
                .show()
        }
    }
    fun moveToMainActivity() {
        // 로그인 후 메인 액티비티로 이동
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
