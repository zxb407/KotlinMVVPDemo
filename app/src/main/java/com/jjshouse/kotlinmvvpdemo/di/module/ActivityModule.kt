package com.jjshouse.kotlinmvvpdemo.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.di.module
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
@Module
class ActivityModule(private val activity: Activity) {
    @Provides
    fun getActivity() = activity
}