package com.core.frame

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import com.core.frame.crash.AndroidCrashHandler
import com.core.frame.manager.ActivityLifecycleManager

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 *
 */
open class LifecycleApplication : Application() {

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        ActivityLifecycleManager.init(this)
        Utils.init(this)
//        AndroidCrashHandler.init(applicationContext)
        setLogRule()
        BuildConfig.APPLICATION_ID
    }

    private fun setLogRule() {
        LogUtils.getConfig()
            .setLogSwitch(BuildConfig.IS_DEBUG)
            .setGlobalTag(BuildConfig.DOMAIN)
    }
}