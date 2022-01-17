package com.example.kotlinpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // TODO : Room 사용법 노션에 정리할 것, syncronized 키워드 알아보기
    private lateinit var getResult : ActivityResultLauncher<Intent>
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    // 액티비티와 생명주기를 달리하는 뷰모델에 라이브데이터를 두어 액티비티가 소멸되어도 데이터를 저장하도록 함
    lateinit var model : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        model = ViewModelProvider(this).get(UserViewModel::class.java)

        model.userProfileList.observe(this, Observer {
            var userList = "사용자 목록"
            for(user in it) {
                userList += "\n" + "${user.id}" + ", ${user.name}" + ", ${user.age}" + ", ${user.phone}"
            }
            binding.profileList.setText(userList)
        })

        // 정보 저장 버튼
        binding.userSaveBtn.setOnClickListener {
            val freshman = User(binding.userName.text.toString(), binding.userAge.text.toString(), 0, binding.userPhone.text.toString())
            model.insert(freshman)
        }


    }

}