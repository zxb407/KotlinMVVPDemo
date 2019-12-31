package com.core.frame.crash

import android.content.Context

interface ICrashHandler {

    /**
     * Report error.
     * @param context context
     * @param e       [Throwable]
     * @param error   message
     */
    fun reportError(context: Context, e: Throwable, error: String)

}
