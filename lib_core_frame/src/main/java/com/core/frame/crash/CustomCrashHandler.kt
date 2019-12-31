package com.core.frame.crash

import android.content.Context
import android.nfc.Tag
import android.os.Process
import android.util.Log
import com.blankj.utilcode.util.LogUtils
import com.core.frame.manager.AppActivityManager

class CustomCrashHandler(context: Context, private val mHandler: Thread.UncaughtExceptionHandler?) :
    BaseCrashhandler(context) {

    /**
     * Handle the uncaught exception.
     *
     * @param thread          [Thread]
     * @param ex              [Throwable]
     * @param formatedMessage formated message
     */
    override fun handleUncaughtException(
        thread: Thread,
        ex: Throwable,
        mainthread: Boolean,
        formatedMessage: String
    ) {
        val context = context
        if (AndroidCrashHandler.REPORTLOG) {
            reportError(context, ex, formatedMessage)
        }
        if (mainthread){
            CrashDialogActivity.launch(context)
            AppActivityManager.instance.AppExit(context)
        }
    }

    /**
     * Report error.
     *
     * @param context context
     * @param e       [Throwable]
     * @param error   message
     */
    override fun reportError(context: Context, e: Throwable, error: String) {

    }
}
