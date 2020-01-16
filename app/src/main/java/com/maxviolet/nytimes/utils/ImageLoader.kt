package com.maxviolet.nytimes.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

open class ImageLoader {

    companion object {
        fun load(context: Context, url: String, into: ImageView) {
            Glide.with(context)
                .load(url)
                .into(into)
        }
    }
}