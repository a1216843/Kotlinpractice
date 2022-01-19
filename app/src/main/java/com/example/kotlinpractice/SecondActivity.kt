package com.example.kotlinpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlinpractice.Fragments.MyFragment1
import com.example.kotlinpractice.Fragments.MyFragment2
import com.example.kotlinpractice.databinding.ActivitySecondBinding
import com.google.android.material.tabs.TabLayoutMediator

const val NUM_PAGES = 2

class SecondActivity : AppCompatActivity() {
    lateinit var viewPager : ViewPager2
    val tabMenuList = arrayListOf("검은색", "빨간색")
    val binding by lazy { ActivitySecondBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        viewPager = binding.pager
        viewPager.adapter = ScreenSlidePagerAdapter(this)
        val dotIndicator = binding.dotsIndicator
        dotIndicator.setViewPager2(viewPager)
        TabLayoutMediator(binding.tablayoutMenu, viewPager) {
            tab, position ->
                tab.text = tabMenuList[position]
        }.attach()
    }

    inner class ScreenSlidePagerAdapter(frag : FragmentActivity) : FragmentStateAdapter(frag) {
        override fun getItemCount(): Int = NUM_PAGES

        override fun createFragment(position: Int): Fragment {
            return when(position) {
                0 -> MyFragment1()
                else -> MyFragment2()
            }
        }

    }
}