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
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    lateinit var viewPager : ViewPager2

    // 액티비티와 생명주기를 달리하는 뷰모델에 라이브데이터를 두어 액티비티가 소멸되어도 데이터를 저장하도록 함
    lateinit var model : UserViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // ViewModel
        model = ViewModelProvider(this).get(UserViewModel::class.java)
        model.userProfileList.observe(this, Observer {
            var userList = "사용자 목록"
            for(user in it) {
                userList += "\n" + "${user.id}" + ", ${user.name}" + ", ${user.age}" + ", ${user.phone}"
            }
            binding.profileList.text = userList
        })

        // 정보 저장 버튼
        binding.userSaveBtn.setOnClickListener {
            val freshman = User(binding.userName.text.toString(), binding.userAge.text.toString(), 0, binding.userPhone.text.toString())
            model.insert(freshman)
        }
        // 액티비티 전환 버튼
        binding.activityMove.setOnClickListener {
            intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        val dotsIndicator = binding.dotsIndicator
        viewPager = binding.pager
        viewPager.adapter = ViewPagerAdapter(getList())
        dotsIndicator.setViewPager2(viewPager)
        viewPager.apply {
            registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    binding.currentNum.text = "${position+1}"
                }
            })
        }
    }

    fun getList() : ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.test1, R.drawable.test2, R.drawable.test3)
    }

}