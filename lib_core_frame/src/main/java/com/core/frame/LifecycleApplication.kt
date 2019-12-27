package com.core.frame

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 *
 */
open class LifecycleApplication :Application(){

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
    override fun onCreate() {
        super.onCreate()
        ActivityLifecycleManager.init(this)
    }
}