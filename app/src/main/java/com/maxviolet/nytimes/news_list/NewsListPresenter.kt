package com.maxviolet.nytimes.news_list

import android.content.Context
import com.maxviolet.nytimes.common.BaseMvpPresenter
import com.maxviolet.nytimes.models.NytNewsItem

class NewsListPresenter: BaseMvpPresenter<NewsListView>() {

    private lateinit var view: NewsListView
    private var listOfNews = mutableListOf<NytNewsItem>()

    /*fun onAttach(view: NewsListView) {
        this.view = view
        downloadNews()
    }*/

    /*fun onDetach() {
        //clear
    }*/

    private fun downloadNews() {

        view.showNews(listOfNews)
    }

}