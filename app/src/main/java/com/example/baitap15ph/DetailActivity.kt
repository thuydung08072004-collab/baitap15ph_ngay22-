package com.example.baitap15ph

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.baitap15ph.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Nhận dữ liệu truyền qua Intent
        val fullName = intent.getStringExtra("FULL_NAME") ?: ""
        val email = intent.getStringExtra("EMAIL") ?: ""
        val phone = intent.getStringExtra("PHONE") ?: ""
        val msv = intent.getStringExtra("MSV") ?: ""
        val className = intent.getStringExtra("CLASS_NAME") ?: ""

        // Đổ dữ liệu ra TextView
        val displayInfo = """
            Họ và tên: $fullName
            Email: $email
            Số điện thoại: $phone
            Mã sinh viên: $msv
            Lớp: $className
        """.trimIndent()

        binding.tvResult.text = displayInfo

        // Bấm nút quay lại màn hình đăng ký
        binding.btnBack.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}