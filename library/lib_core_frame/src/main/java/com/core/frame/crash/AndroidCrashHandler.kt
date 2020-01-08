package com.core.frame.crash

import android.content.Context

object AndroidCrashHandler {
    var REPORTLOG = false
    fun init(context: Context) {
        var originUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler(
            CustomCrashHandler(
                context,
                originUncaughtExceptionHandler
            )
        )
    }
}
