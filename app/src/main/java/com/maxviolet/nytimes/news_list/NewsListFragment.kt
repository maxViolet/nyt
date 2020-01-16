package com.maxviolet.nytimes.news_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.maxviolet.nytimes.R
import com.maxviolet.nytimes.models.NytNewsItem
import javax.inject.Inject

class NewsListFragment() : Fragment(), NewsListView {

    @Inject lateinit var presenter2: NewsListPresenter

    private lateinit var root: ViewGroup
    private lateinit var presenter: NewsListPresenter
    private val adapter: NewsListAdapter by lazy { NewsListAdapter(activity!!) }
    private val recyclerView by lazy { R.id.recycler_view }

    companion object {
        const val TAG: String = "news_list_fragment"
        const val LAYOUT: Int = R.layout.fragment_news_list

        fun getInstance() = NewsListFragment.apply {
            var arguments = Bundle().apply {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = NewsListPresenter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(LAYOUT, null) as ViewGroup

        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        presenter.onAttach(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.onDetach()
    }

    override fun showNews(list: List<NytNewsItem>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
