package com.jjshouse.kotlinmvvpdemo

import android.os.Handler
import android.os.Process
import com.core.frame.LifecycleApplication

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

    fun getMainHandler(): Handler {
        return handler
    }

    fun exitProcess() {
        Process.killProcess(Process.myPid())
        System.exit(0)
    }

    companion object{
        lateinit var instance: JJApplication
        lateinit var handler: Handler
    }
}