package com.maxviolet.nytimes.common

import androidx.annotation.NonNull


abstract class BaseMvpPresenter<V : BaseMvpView> {

    private var view: V? = null

    open fun onAttach(@NonNull view: V) {
        this.view = view
    }

    protected fun getView(): V? {
        return this.view
    }


    open fun onDetach() {
        view = null
    }

    open fun onDestroy() {

    }

}