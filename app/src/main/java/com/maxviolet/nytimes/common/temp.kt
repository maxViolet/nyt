package com.maxviolet.nytimes.common

import androidx.annotation.NonNull
import androidx.annotation.Nullable

abstract class BaseMvpPresenter2<V : BaseMvpView?> {
    @get:Nullable
    protected var view: V? = null
        private set

    fun onAttach(@NonNull view: V) {
        this.view = view
    }

    fun onDetach() {
        view = null
    }

    fun onDestroy() {}
}