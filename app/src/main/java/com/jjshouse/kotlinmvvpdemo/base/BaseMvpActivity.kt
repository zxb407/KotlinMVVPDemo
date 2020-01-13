package com.jjshouse.kotlinmvvpdemo.base

import com.jjshouse.kotlinmvvpdemo.di.component.DaggerActivityComponent
import com.jjshouse.kotlinmvvpdemo.di.component.DaggerContractViewComponent
import com.jjshouse.kotlinmvvpdemo.di.module.ActivityModule
import com.jjshouse.kotlinmvvpdemo.di.module.IViewModule
import org.cchao.kotlintemplate.expansion.getAppComponent
import org.cchao.kotlintemplate.ui.base.BasePresenter
import org.cchao.kotlintemplate.ui.base.BaseView
import javax.inject.Inject

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.base
 * Created by xbzhang on 2019/12/31
 * Description:
 *
 */
abstract class BaseMvpActivity<T : BasePresenter> : BaseStateActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    override fun initComponentBuilder() {
        activityComponentBuilder = DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .appComponent(getAppComponent()).contractViewComponent(DaggerContractViewComponent.builder().iViewModule(
                IViewModule(this)
            ).build())
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}