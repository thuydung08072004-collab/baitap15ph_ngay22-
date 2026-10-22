package com.example.baitap15ph

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.example.baitap15ph.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            if (validateForm()) {
                val fullName = binding.etFullName.text.toString().trim()
                val email = binding.etEmail.text.toString().trim()
                val phone = binding.etPhone.text.toString().trim()
                val msv = binding.etMsv.text.toString().trim()
                val className = binding.etClass.text.toString().trim()

                // Dùng Intent để chuyển trang và truyền dữ liệu
                val intent = Intent(this, DetailActivity::class.java).apply {
                    putExtra("FULL_NAME", fullName)
                    putExtra("EMAIL", email)
                    putExtra("PHONE", phone)
                    putExtra("MSV", msv)
                    putExtra("CLASS_NAME", className)
                }
                startActivity(intent)
            }
        }
    }

    private fun validateForm(): Boolean {
        var isValid = true

        val fullName = binding.etFullName.text.toString().trim()
        val email = binding.etEmail.text.toString().trim()
        val phone = binding.etPhone.text.toString().trim()
        val msv = binding.etMsv.text.toString().trim()
        val className = binding.etClass.text.toString().trim()

        // Kiểm tra Họ tên
        if (fullName.isEmpty()) {
            binding.tilFullName.error = "Vui lòng nhập họ tên"
            isValid = false
        } else {
            binding.tilFullName.error = null
        }

        // Kiểm tra Email
        if (email.isEmpty()) {
            binding.tilEmail.error = "Vui lòng nhập email"
            isValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            binding.tilEmail.error = "Email không hợp lệ"
            isValid = false
        } else {
            binding.tilEmail.error = null
        }

        // Kiểm tra Số điện thoại
        if (phone.isEmpty()) {
            binding.tilPhone.error = "Vui lòng nhập số điện thoại"
            isValid = false
        } else if (phone.length < 10 || !phone.all { it.isDigit() }) {
            binding.tilPhone.error = "Số điện thoại không hợp lệ"
            isValid = false
        } else {
            binding.tilPhone.error = null
        }

        // Kiểm tra MSV
        if (msv.isEmpty()) {
            binding.tilMsv.error = "Vui lòng nhập mã sinh viên"
            isValid = false
        } else {
            binding.tilMsv.error = null
        }

        // Kiểm tra Lớp
        if (className.isEmpty()) {
            binding.tilClass.error = "Vui lòng nhập tên lớp"
            isValid = false
        } else {
            binding.tilClass.error = null
        }

        return isValid
    }
}