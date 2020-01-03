package com.jjshouse.kotlinmvvpdemo.di.component

import com.jjshouse.kotlinmvvpdemo.di.module.IViewModule
import dagger.Component
import org.cchao.kotlintemplate.ui.base.BaseView

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.di.component
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
@Component(modules = [IViewModule::class])
interface ContractViewComponent {
    fun getContractView(): BaseView
}