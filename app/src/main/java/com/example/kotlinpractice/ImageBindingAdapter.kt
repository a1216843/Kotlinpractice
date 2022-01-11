package com.example.kotlinpractice

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ImageBindingAdapter {
    companion object {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun loadImageUrl(view: ImageView, url: String) {
            Glide.with(view.getContext()).load(url).into(view)
        }
    }
}