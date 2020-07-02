package com.core.frame.app

import android.app.Application
import android.content.Context
import android.os.Handler
import android.os.Process
import androidx.multidex.MultiDex
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.Utils
import com.core.frame.BuildConfig
import com.core.frame.R
import com.core.frame.manager.ActivityLifecycleManager
import com.core.frame.manager.NetWorkStateMonitor
import com.core.frame.utils.ToastUtils
import leakcanary.LeakCanary

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 *
 */
open class BaseApplication : Application() {

    init {
        handler = Handler()
    }

    companion object{
        lateinit var handler: Handler
        lateinit var instance: BaseApplication

    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        ActivityLifecycleManager.init(this)
        NetWorkStateMonitor.init(this)
        Utils.init(this)
        initLogRule()
        initToastRule()
    }

    private fun initToastRule() {
        ToastUtils.setBgColor(resources.getColor(R.color.toastBg))
        ToastUtils.setMsgColor(resources.getColor(R.color.toastTextColor))
        ToastUtils.setMsgTextSize(14)
    }

    private fun initLogRule() {
        LogUtils.getConfig()
            .setLogSwitch(BuildConfig.IS_DEBUG)
            .setGlobalTag(BuildConfig.DOMAIN)
            .setBorderSwitch(false)
    }

    fun getMainThreadId(): Int {
        return Process.myPid()
    }

    fun getMainHandler(): Handler {
        return handler
    }
}