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
        val db = UserDatabase.getInstance(applicationContext)
        model = ViewModelProvider(this).get(UserViewModel::class.java)
        model.liveData.observe(this, Observer {
            binding.user = it
        })
        // livedata 초기화
        if(model.liveData.value == null) {
            model.liveData.apply {
                value = User("홍길동", "27", 0, "010-0000-1111")
            }
        }


        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK) {
                val user = model.liveData.value
                user?.phone = it.data?.getStringExtra("phone").toString()
                model.liveData.apply {
                    value = user
                }
            }
        }
        // 정보 수정 버튼
        binding.userConfigBtn.setOnClickListener {
            val intent = Intent(this, EditUserActivity::class.java)
            getResult.launch(intent)
        }
        // 정보 저장 버튼
        binding.userSaveBtn.setOnClickListener {
            db!!.userDao().insert(model.liveData.value!!)
            // db에 저장된 모든 User 데이터들 중 phone만 출력
            for(i in db.userDao().getAll()) {
                println(i.phone)
            }
        }


    }

//    현재 액티비티의 상태를 저장해두고 화면전환 등으로 액티비티가 다시 onCreate될 때 상태를 전달함
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//
//    }



}