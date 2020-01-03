package com.jjshouse.kotlinmvvpdemo.di.component

import com.jjshouse.kotlinmvvpdemo.JJApplication
import com.jjshouse.kotlinmvvpdemo.di.module.ActivityModule
import com.jjshouse.kotlinmvvpdemo.di.module.FragmentModule
import com.jjshouse.kotlinmvvpdemo.di.scope.AppScope
import com.jjshouse.kotlinmvvpdemo.di.module.AppModule
import dagger.Component

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 *
 */
@AppScope
@Component(modules = [AppModule::class])
interface AppComponent{

    fun inject(app: JJApplication)
//    fun plus(module: ActivityModule): ActivityComponent
//    fun plus(module: FragmentModule): FragmentComponent
}

