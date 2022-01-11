package com.example.kotlinpractice

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlinpractice.databinding.ActivityEditUserBinding

open class EditUserActivity : AppCompatActivity() {
    val binding by lazy { ActivityEditUserBinding.inflate(layoutInflater) }
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.saveBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("phone", binding.phone.text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}