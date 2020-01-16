package com.maxviolet.nytimes.common

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.maxviolet.nytimes.BaseApplication

abstract class BaseMvpActivity : Activity() {

    private lateinit var application: BaseApplication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        application = this.application as BaseApplication
        if (this !is BaseMvpView) {
            throw IllegalStateException()
        }
    }

    override fun onResume() {
        super.onResume()

        for (presenter in getPresenters().values) {
            presenter.onDetach()
        }
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()

        if (isFinishing) {
            for (presenter in getPresenters().values) {
                presenter.onDestroy()
            }
            application.clearPresenterStore()
        }
    }

    private fun getPresenters(): HashMap<String, BaseMvpPresenter<*>> {
        return application.getPresenters(getStoreKey())
    }

    internal fun <T : BaseMvpPresenter<*>> getPresenter(presenter: Class<T>) {

    }

    private fun getStoreKey(): String {
        return this.javaClass.simpleName
    }
}