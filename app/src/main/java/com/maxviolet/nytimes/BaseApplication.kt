package com.maxviolet.nytimes

import android.app.Application
import android.util.Log
import com.maxviolet.nytimes.common.BaseMvpPresenter
import com.maxviolet.nytimes.common.BaseMvpView
import com.maxviolet.nytimes.di.AppComponent
import com.maxviolet.nytimes.di.AppModule
import com.maxviolet.nytimes.di.DaggerAppComponent

open class BaseApplication : Application() {

    private val presenterStore = HashMap<String, HashMap<String, BaseMvpPresenter<*>>>()
    private lateinit var newsComponent: AppComponent

    private fun initDagger(app: BaseApplication): AppComponent =
        DaggerAppComponent.builder()
            .appModule(AppModule(app))
            .build()

    override fun onCreate() {
        super.onCreate()
        newsComponent = initDagger(this)
    }

    /* override fun onCreate() {
         super.onCreate()
         DaggerAppComponent.builder()
             .application(this)
             .build()
             .inject(this)
     }*/

//    companion object {
//        val instance = NewsApplication()
//    }

    private fun <T : BaseMvpPresenter<*>> savePresenter(
        storeKey: String,
        presenterKey: String,
        presenterClass: Class<T>
    ): T {

        val presenters: HashMap<String, BaseMvpPresenter<*>> = getPresenters(storeKey)
        val presenter = presenters[storeKey]
        if (presenter != null) {
            return presenter as T
        }

        try {
            val newPresenter: T = presenterClass.newInstance()
            presenters[presenterKey] = newPresenter
            presenterStore[storeKey] = presenters
            return newPresenter

        } catch (e: Throwable /*IllegalAccessException | a: InstantiationException*/) {
            when (e) {
                is IllegalAccessException -> Log.e("ERROR: ", e.message)
                is InstantiationException -> Log.e("ERROR: ", e.message)
            }
            throw IllegalStateException()
        }
    }

    fun <T : BaseMvpPresenter<*>> getPresenter(storeKey: String, presenter: Class<T>): T {
        val presenterKey: String = presenter.simpleName
        return savePresenter(storeKey, presenterKey, presenter)

    }

    fun getPresenters(storeKey: String): HashMap<String, BaseMvpPresenter<*>> {
        var presenters = presenterStore[storeKey]
        if (presenters == null) presenters = HashMap()
        return presenters
    }

    fun clearPresenterStore() {

    }
}