package com.maxviolet.nytimes.news_list

import com.maxviolet.nytimes.common.BaseMvpView
import com.maxviolet.nytimes.models.NytNewsItem

interface NewsListView : BaseMvpView {

    fun showNews(list: List<NytNewsItem>)
    fun showError()
    fun showProgress()
}