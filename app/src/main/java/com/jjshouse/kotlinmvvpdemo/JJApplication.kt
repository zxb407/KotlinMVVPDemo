package com.jjshouse.kotlinmvvpdemo

import com.core.frame.BaseApplication
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric



/**
 * PackageName: com.jjshouse.kotlinmvvpdemo
 * Created by xbzhang on 2019/12/26
 * Description:
 *
 */
class JJApplication : BaseApplication() {

    init {
        instance = this
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics()) //此处手动初始化crashlytics，firecrash -> customCrashHandler -> defaultCrashHandler
    }

    companion object {
        lateinit var instance: JJApplication
    }
}