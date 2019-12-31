package com.core.frame.crash

import android.content.Context
import android.os.Looper
import android.util.Log
import com.blankj.utilcode.util.LogUtils

import java.io.PrintWriter
import java.io.StringWriter
import java.lang.Thread.UncaughtExceptionHandler

abstract class BaseCrashhandler(protected val context: Context) : ICrashHandler, UncaughtExceptionHandler {

    /**
     * Wheather current thread is the main thread.
     *
     * @return true, main thread; false, otherwise.
     */
    private val isMainThread: Boolean
        get() = Looper.myLooper() == Looper.getMainLooper()

    /**
     * Handle the uncaught exception.
     *
     * @param thread          [Thread]
     * @param ex              [Throwable]
     * @param mainthread      wheather the main thread
     * @param formatedMessage formated message
     */
    protected abstract fun handleUncaughtException(
        thread: Thread,
        ex: Throwable,
        mainthread: Boolean,
        formatedMessage: String
    )

    /**
     * Show the alert dialog
     *
     * @param context
     */
    private fun showAlertDialog(context: Context) {
        CrashDialogActivity.launch(context)
    }

    /**
     * The thread is being terminated by an uncaught exception. Further
     * exceptions thrown in this method are prevent the remainder of the
     * method from executing, but are otherwise ignored.
     *
     * @param thread the thread that has an uncaught exception
     * @param ex     the exception that was thrown
     */
    override fun uncaughtException(thread: Thread, ex: Throwable) {
        val isMainThread = isMainThread
        val writer = StringWriter()
        ex.printStackTrace(PrintWriter(writer))
        writer.flush()

        val builder = StringBuilder()
        builder.append("[thread name]: ")
        builder.append(thread.name)
        builder.append("; \n")
        builder.append("[mainthread]: ")
        builder.append(isMainThread)
        builder.append("; \n")
        builder.append("[message]: ")
        builder.append(ex.message)
        builder.append("; \n")
        builder.append("[stacktrace]: ")
        builder.append(writer.toString())
        val reportMessage = builder.toString()
        LogUtils.eTag("[crash]", reportMessage)
        if (!isMainThread){
            showAlertDialog(context)
        }
        handleUncaughtException(thread, ex, isMainThread, reportMessage)
    }

    companion object {
        private val ERROR_FORMATER = "[androidcrash] [%s] [%s], message: %s; stacktrace: %s."
    }

}
