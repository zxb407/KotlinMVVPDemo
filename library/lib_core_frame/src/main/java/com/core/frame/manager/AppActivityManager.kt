package com.core.frame.manager

import android.app.Activity
import android.content.Context
import android.os.Process
import com.blankj.utilcode.util.LogUtils
import java.util.Stack

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description: manage activity
 *
 */

class AppActivityManager private constructor() {

    /**
     * get top activity
     */
    val topActivity: Activity
        get() = mActivityStack!!.lastElement()

    /**
     * add activity
     */
    fun addActivity(activity: Activity) {
        if (mActivityStack == null) {
            mActivityStack = Stack()
        }
        mActivityStack!!.add(activity)
    }

    /**
     * remove activity
     */
    fun removeActivity(activity: Activity) {
        mActivityStack!!.remove(activity)
    }

    /**
     * kill top Activity
     */
    fun killTopActivity() {
        val activity = mActivityStack!!.lastElement()
        killActivity(activity)
    }

    /**
     * kill specfic Activity
     */
    private fun killActivity(activity: Activity?) {
        if (activity != null) {
            mActivityStack!!.remove(activity)
            activity.finish()
        }
    }

    /**
     * kill specfic Activity
     */
    fun killActivity(cls: Class<*>) {
        for (activity in mActivityStack!!) {
            if (activity.javaClass == cls) {
                killActivity(activity)
            }
        }
    }

    /**
     * kill all Activity
     */
    fun killAllActivity() {
        var i = 0
        val size = mActivityStack!!.size
        while (i < size) {
            if (null != mActivityStack!![i]) {
                mActivityStack!![i].finish()
            }
            i++
        }
        mActivityStack!!.clear()
    }

    /**
     * exit app
     */
    fun AppExit() {
        try {
            if (mActivityStack!!.size <= 1) {
                killAllActivity()
            }
            Process.killProcess(Process.myPid())
            System.exit(1)
        } catch (e: Exception) {
            LogUtils.vTag("AppActivityManager", "" + e)
        }
    }

    companion object {
        private var mActivityStack: Stack<Activity>? = null
        private var mAppManager: AppActivityManager? = null
        /**
         * single instance
         */
        val instance: AppActivityManager
            get() {
                if (mAppManager == null) {
                    mAppManager =
                        AppActivityManager()
                }
                return mAppManager as AppActivityManager
            }
    }
}
