package com.core.frame.manager

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import com.blankj.utilcode.util.LogUtils
import java.lang.ref.WeakReference
import java.util.concurrent.CopyOnWriteArrayList


/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/27
 * Description:
 *
 */
class ActivityLifecycleManager : Application.ActivityLifecycleCallbacks {

    private var totalActivityCount = 0
    private var activityCount = 0
    private var foreground = false
    private var sCurrentActivityWeakRef: WeakReference<Activity>? = null
    private val listeners = CopyOnWriteArrayList<AppStateListener>()

    companion object {
        private var instance: ActivityLifecycleManager? = null
        fun init(application: Application): ActivityLifecycleManager {
            if (instance == null) {
                instance =
                    ActivityLifecycleManager()
                application.registerActivityLifecycleCallbacks(instance)
            }
            return instance as ActivityLifecycleManager
        }

        operator fun get(application: Application): ActivityLifecycleManager? {
            if (instance == null) {
                init(application)
            }
            return instance
        }

        operator fun get(ctx: Context): ActivityLifecycleManager {
            if (instance == null) {
                val appCtx = ctx.applicationContext
                if (appCtx is Application) {
                    init(appCtx)
                }
                throw IllegalStateException(
                    "Foreground is not initialised and " + "cannot obtain the Application object"
                )
            }
            return instance as ActivityLifecycleManager
        }

        fun get(): ActivityLifecycleManager {
            if (instance == null) {
                throw IllegalStateException(
                    "Foreground is not initialised - invoke " + "at least once with parameterised init/get"
                )
            }
            return instance as ActivityLifecycleManager
        }
    }

    override fun onActivityCreated(activity: Activity, p1: Bundle?) {
        totalActivityCount++
        AppActivityManager.instance.addActivity(activity)
    }

    override fun onActivityStarted(activity: Activity) {
        activityCount++
    }

    override fun onActivitySaveInstanceState(activity: Activity, p1: Bundle) {
    }

    override fun onActivityResumed(activity: Activity) {
        sCurrentActivityWeakRef = WeakReference(activity)
        if (!foreground) {
            foreground = true
            LogUtils.dTag("Lifecycle", "app into the foreground")
        }
    }

    override fun onActivityPaused(activity: Activity) {
    }

    override fun onActivityStopped(activity: Activity) {
        activityCount--
        if (activityCount == 0 && totalActivityCount > 0) {
            foreground = false
            LogUtils.dTag("Lifecycle", "app into the background")
        }

    }

    override fun onActivityDestroyed(activity: Activity) {
        totalActivityCount--
        AppActivityManager.instance.removeActivity(activity)
        if (totalActivityCount == 0) LogUtils.dTag("Lifecycle", "app exit")
    }

    fun isForeground(): Boolean {
        return foreground
    }

    fun isBackground(): Boolean {
        return !foreground
    }

    fun getCurrentActivity(): Activity? {
        return sCurrentActivityWeakRef?.get()
    }

    fun addListener(listener: AppStateListener) {
        listeners.add(listener)
    }

    fun removeListener(listener: AppStateListener) {
        listeners.remove(listener)
    }

    interface AppStateListener {
        fun onBecameForeground()
        fun onBecameBackground()
    }
}