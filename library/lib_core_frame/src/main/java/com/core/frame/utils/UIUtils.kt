package com.core.frame.utils

import android.content.Context
import android.content.res.Resources
import android.os.Handler
import android.view.View
import com.core.frame.app.BaseApplication

/**
 * **Create Date:** 2018/3/5<br></br>
 * **Author:** Zhanglei<br></br>
 * **Description:** <br></br>
 */

object UIUtils {
    val context: Context
        get() = BaseApplication.instance.applicationContext


    val resources: Resources
        get() = context.resources

    /**
     * 是否运行在主线程
     * @return
     */
    val isRunOnMainThread: Boolean
        get() = android.os.Process.myPid() == mainThreadId

    val mainThreadId: Int
        get() = BaseApplication.instance.getMainThreadId()

    val handler: Handler
        get() = BaseApplication.handler

    /**
     * dp转换为px
     */
    fun dp2px(dp: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (dp * scale + 0.5f).toInt()
    }

    /**
     * px转换为dp
     */
    fun px2dp(px: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (px / scale + 0.5f).toInt()
    }

    /**
     * 获取字符
     * @param id
     * @return
     */
    fun getString(id: Int): String {
        return resources.getString(id)
    }

    /**
     * 获取字符数组
     *
     * @param id
     * @return
     */
    fun getStringArrays(id: Int): Array<String> {
        return resources.getStringArray(id)
    }

    /**
     * 获取颜色
     */
    fun getColor(id: Int): Int {
        return resources.getColor(id)
    }

    /**
     * 根据id获取尺寸
     * @param id
     * @return
     */
    fun getDimens(id: Int): Int {
        return resources.getDimensionPixelOffset(id)
    }

    fun inflate(id: Int): View {
        return View.inflate(context, id, null)
    }

    fun runOnUiThread(runnable: Runnable) {
        if (isRunOnMainThread) {
            runnable.run()
        } else {
            post(runnable)
        }
    }

    fun post(runnable: Runnable) {
        val handler = handler
        handler.post(runnable)
    }
}
