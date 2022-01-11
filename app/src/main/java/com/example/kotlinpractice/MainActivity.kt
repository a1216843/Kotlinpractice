package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.kotlinpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // TODO : 화면에 출력할 man 데이터를 수정하는 기능 구현할 것 -> LiveData 예제용
    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        var man = User("홍길동", "27", 0)

        man.url = "https://ifh.cc/g/NWPI5Q.png" //이미지 호스팅 url

        binding.user = man

        // 일반적인 버튼 사용 예시 -> 인터페이스를 파라미터로 가져옴
//        binding.button.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//                // to do..
//            }
//        })
        // 람다식을 이용한 버튼 예시
        // 1. Kotlin interface가 아닌 Java interface여야 한다.
        // 2. 그 interface는 단 하나의 메소드만 가져야 한다.
//        binding.button.setOnClickListener {
//            // to do..
//        }
    }
}