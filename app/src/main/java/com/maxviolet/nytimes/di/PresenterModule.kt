package com.maxviolet.nytimes.di

import com.maxviolet.nytimes.news_list.NewsListPresenter
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class PresenterModule {

    @Provides
    @Singleton
    fun provideNewsListFragmentPresenter(): NewsListPresenter = NewsListPresenter()

}