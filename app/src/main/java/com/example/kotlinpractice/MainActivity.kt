package com.example.kotlinpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.kotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var getResult : ActivityResultLauncher<Intent>
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var man = User("홍길동", "27", 0, "010-0000-1111")

        binding.user = man

        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK) {
                man.phone = it.data?.getStringExtra("phone").toString()
                binding.user = man
            }
        }

        binding.userConfigBtn.setOnClickListener {
            val intent = Intent(this, EditUserActivity::class.java)
            getResult.launch(intent)
        }
    }



}