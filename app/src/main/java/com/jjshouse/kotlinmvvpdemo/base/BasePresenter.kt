package com.jjshouse.kotlinmvvpdemo.base

import io.reactivex.disposables.CompositeDisposable

interface BasePresenter {

    fun detachView()

    fun getPauseCompositeDisposable(): CompositeDisposable

    fun unSubscribeOnPause()

    fun getDestroyCompositeDisposable(): CompositeDisposable

    fun unSubscribeOnDestroy()
}