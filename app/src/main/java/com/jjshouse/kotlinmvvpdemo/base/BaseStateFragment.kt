package com.jjshouse.kotlinmvvpdemo.base

import android.view.View
import com.jjshouse.kotlinmvvpdemo.widget.StateLayout

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.base
 * Created by xbzhang on 2020/1/10
 * Description:
 *
 */
abstract class BaseStateFragment :BaseFragment(), StateLayout.OnReloadListener {
    lateinit var stateLayout: StateLayout

    override fun getContentView(): View {
        stateLayout = StateLayout(mActivity)
        stateLayout.bindSuccessView(getSuccessView())
        stateLayout.bindLoadingView(getLoadingView())
        stateLayout.bindEmptyView(getEmptyView())
        stateLayout.bindErrorView(getErrorView())
        stateLayout.setOnReloadListener(this)
        stateLayout.showSuccessView()
        return stateLayout
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