package com.jjshouse.kotlinmvvpdemo

import android.os.Handler
import com.core.frame.LifecycleApplication
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric



/**
 * PackageName: com.jjshouse.kotlinmvvpdemo
 * Created by xbzhang on 2019/12/26
 * Description:
 *
 */
class JJApplication : LifecycleApplication() {

    init {
        instance = this
        handler = Handler()
    }

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics()) //此处手动初始化crashlytics，firecrash -> customCrashHandler -> defaultCrashHandler
    }

    fun getMainHandler(): Handler {
        return handler
    }

    companion object {
        lateinit var instance: JJApplication
        lateinit var handler: Handler
    }
}