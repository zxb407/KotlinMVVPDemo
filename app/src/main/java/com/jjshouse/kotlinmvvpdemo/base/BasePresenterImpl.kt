package org.cchao.kotlintemplate.ui.base

import io.reactivex.disposables.CompositeDisposable

open class BasePresenterImpl<T : BaseView>() : BasePresenter {

    private var presenterView: T? = null

    constructor(view: BaseView) : this() {
        presenterView = (view as T)
    }

    private var pauseCompositeDisposable: CompositeDisposable? = null

    private var destroyCompositeDisposable: CompositeDisposable? = null

    override fun detachView() {
        presenterView = null
    }

//    @Inject
//    fun setPresenter() {
//        presenterView?.setPresenter(this)
//    }

    protected fun getPresenterView(): T? {
        return presenterView
    }

    override fun getPauseCompositeDisposable(): CompositeDisposable {
        if (null == pauseCompositeDisposable) {
            pauseCompositeDisposable = CompositeDisposable()
        }
        return pauseCompositeDisposable!!
    }

    override fun unSubscribeOnPause() {
        if (null != pauseCompositeDisposable && !pauseCompositeDisposable!!.isDisposed) {
            pauseCompositeDisposable!!.dispose()
        }
    }

    override fun getDestroyCompositeDisposable(): CompositeDisposable {
        if (null == destroyCompositeDisposable) {
            destroyCompositeDisposable = CompositeDisposable()
        }
        return destroyCompositeDisposable!!
    }

    override fun unSubscribeOnDestroy() {
        if (null != destroyCompositeDisposable && !destroyCompositeDisposable!!.isDisposed) {
            destroyCompositeDisposable!!.dispose()
        }
    }
}