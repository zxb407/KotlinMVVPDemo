package com.jjshouse.kotlinmvvpdemo.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentActivity
import com.core.frame.base.MToolbarFragment
import com.core.frame.model.NetWorkChangeEvent
import com.jjshouse.kotlinmvvpdemo.JJApplication
import com.jjshouse.kotlinmvvpdemo.di.component.DaggerFragmentComponent
import com.jjshouse.kotlinmvvpdemo.di.component.FragmentComponent
import com.jjshouse.kotlinmvvpdemo.di.module.FragmentModule
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.base
 * Created by xbzhang on 2020/1/10
 * Description:
 *
 */
abstract class BaseFragment : MToolbarFragment() {

    open lateinit var mActivity: FragmentActivity
    private var mIsPrepare: Boolean = false
    private var mIsVisible: Boolean = false
    lateinit var fragmentComponentBuilder: DaggerFragmentComponent.Builder

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = this.activity!!
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponentBuilder()
        inject()
        EventBus.getDefault().register(this)
        initView()
        initEvent()
        initData()
        mIsPrepare = true
    }

    open fun initComponentBuilder() {
        fragmentComponentBuilder = DaggerFragmentComponent.builder().fragmentModule(FragmentModule(this))
            .appComponent(JJApplication.instance.appComponent)
    }

    fun getInjector(): FragmentComponent {
        return fragmentComponentBuilder.build()
    }

    //使用show和hide来显隐的Fragment
    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        this.mIsVisible = !hidden
        if (!hidden && mIsPrepare) {
            onVisibleToUser()
        } else {
            onInvisibleToUser()
        }
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        this.mIsVisible = isVisibleToUser
        if (isVisibleToUser && mIsPrepare) {
            onVisibleToUser()
        } else {
            onInvisibleToUser()
        }
    }


    override fun onResume() {
        super.onResume()
        this.mIsVisible = true
    }

    override fun onPause() {
        super.onPause()
        this.mIsVisible = false
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    abstract fun inject()

    abstract fun onVisibleToUser()

    abstract fun onInvisibleToUser()

    abstract fun initView()

    abstract fun initEvent()

    abstract fun initData()

    // =============================================== Network state callBack ======================================

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onNetChangeEvent(networkChangeEvent: NetWorkChangeEvent) {
        hasNetWork(networkChangeEvent.isConnect)
    }

    private fun hasNetWork(has: Boolean) {
        if (isMonitorNetWork()) {
            if (has) {
                onTryAgain()
            }
        }
    }

    abstract fun onTryAgain()

    abstract fun isMonitorNetWork(): Boolean
}