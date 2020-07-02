package com.jjshouse.kotlinmvvpdemo.base

import com.jjshouse.kotlinmvvpdemo.JJApplication
import com.jjshouse.kotlinmvvpdemo.di.component.DaggerContractViewComponent
import com.jjshouse.kotlinmvvpdemo.di.component.DaggerFragmentComponent
import com.jjshouse.kotlinmvvpdemo.di.module.FragmentModule
import com.jjshouse.kotlinmvvpdemo.di.module.IViewModule
import javax.inject.Inject

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.base
 * Created by xbzhang on 2019/12/31
 * Description:
 *
 */
abstract class BaseMvpFragment<T : BasePresenter> : BaseStateFragment(), BaseView {

    @Inject
    lateinit var mPresenter: T

    override fun initComponentBuilder() {
        fragmentComponentBuilder = DaggerFragmentComponent.builder().fragmentModule(FragmentModule(this))
            .appComponent(JJApplication.instance.appComponent).contractViewComponent(
                DaggerContractViewComponent.builder()
                    .iViewModule(IViewModule(this)).build()
            )
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}