package com.jjshouse.kotlinmvvpdemo.di.module

import dagger.Module
import dagger.Provides
import com.jjshouse.kotlinmvvpdemo.base.BaseView

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.di.module
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
@Module
class IViewModule(private val mView: BaseView) {

    @Provides
    fun provideContractView(): BaseView {
        return mView
    }
}