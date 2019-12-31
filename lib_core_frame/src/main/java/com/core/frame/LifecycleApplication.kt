package com.core.frame

import android.app.Application
import android.content.Context
import android.os.Handler
import androidx.multidex.MultiDex
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import com.core.frame.crash.AndroidCrashHandler
import com.core.frame.manager.ActivityLifecycleManager
import com.core.frame.manager.NetWorkStateMonitor

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 *
 */
open class LifecycleApplication : Application() {

    init {
        handler = Handler()
    }

    companion object{
        lateinit var handler: Handler
        lateinit var instance:LifecycleApplication

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        ActivityLifecycleManager.init(this)
        AndroidCrashHandler.init(applicationContext)
        NetWorkStateMonitor.init(this)
        Utils.init(this)
        initLogRule()
    }

    private fun initLogRule() {
        LogUtils.getConfig()
            .setLogSwitch(BuildConfig.IS_DEBUG)
            .setGlobalTag(BuildConfig.DOMAIN)
            .setBorderSwitch(false)
    }
}