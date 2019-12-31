package com.jjshouse.kotlinmvvpdemo.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager


object SystemUtils {

    /**
     * 切换输入法显示状态, 如果输入法已显示, 则隐藏输入法, 反之则显示输入法.
     *
     * @param context
     */
    fun toggleInputMethod(context: Context) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun showInputMethod(context: Context) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (!imm.isActive) {
            imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED)
        }
    }

    fun showInputMethod(v: View) {
        val context = v.context
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInputFromInputMethod(v.windowToken, 0)
    }

    fun hideInputMethod(v: View) {
        val context = v.context
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(v.windowToken, 0)
    }

    fun hideInputMethod(context: Context) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (imm.isActive) {
            imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }

    fun isInputMethodActive(context: Context): Boolean {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        return imm.isActive
    }
}// no-instance
