package com.jjshouse.kotlinmvvpdemo.base

import android.view.View
import com.jjshouse.kotlinmvvpdemo.widget.StateLayout

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.base
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
abstract class BaseStateActivity : BaseActivity(), StateLayout.OnReloadListener {

    lateinit var stateLayout: StateLayout

    override fun initLayout() {
        stateLayout = StateLayout(this)
        stateLayout.bindSuccessView(getSuccessView())
        stateLayout.bindLoadingView(getLoadingView())
        stateLayout.bindEmptyView(getEmptyView())
        stateLayout.bindErrorView(getErrorView())
        setContentView(stateLayout)
        stateLayout.setOnReloadListener(this)
        stateLayout.showSuccessView()
    }

    open fun getLoadingView(): View? {
        return null
    }

    abstract fun getSuccessView(): View

    open fun getEmptyView(): View? {
        return null
    }

    open fun getErrorView(): View? {
        return null
    }

    override fun onReload() {
        onTryAgain()
    }
}
