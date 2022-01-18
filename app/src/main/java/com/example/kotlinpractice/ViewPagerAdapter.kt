package com.example.kotlinpractice

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinpractice.databinding.TestItemListBinding

class ViewPagerAdapter(testList : ArrayList<Int>) : RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {
    val item = testList
    lateinit var binding: TestItemListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.test_item_list, parent, false)
        return PagerViewHolder(TestItemListBinding.bind(view))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.PagerViewHolder, position: Int) {
        holder.test.setImageResource(item[position])
    }

    override fun getItemCount(): Int = item.size

    inner class PagerViewHolder(binding: TestItemListBinding) : RecyclerView.ViewHolder(binding.root) {
        val test = binding.imageViewTest
    }

}