package com.jjshouse.kotlinmvvpdemo.base

import com.jjshouse.kotlinmvvpdemo.di.component.DaggerContractViewComponent
import com.jjshouse.kotlinmvvpdemo.di.module.IViewModule
import org.cchao.kotlintemplate.ui.base.BasePresenter
import org.cchao.kotlintemplate.ui.base.BaseView
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
        super.initComponentBuilder()
        fragmentComponentBuilder.contractViewComponent(
            DaggerContractViewComponent.builder().iViewModule(
                IViewModule(
                    this
                )
            ).build()
        ).build()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}