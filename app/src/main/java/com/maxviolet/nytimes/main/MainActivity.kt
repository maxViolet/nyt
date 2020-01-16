package com.maxviolet.nytimes.main

import android.os.Bundle
import com.maxviolet.nytimes.R

class MainActivity : BaseMvpActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_news_list)
    }
}
