package com.jjshouse.kotlinmvvpdemo.di.module

import android.content.Context
import com.google.gson.Gson
import com.jjshouse.kotlinmvvpdemo.di.scope.AppScope
import dagger.Module
import dagger.Provides

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 *
 */

@Module
class AppModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @AppScope
    @Provides
    fun provideGson() = Gson()
}
