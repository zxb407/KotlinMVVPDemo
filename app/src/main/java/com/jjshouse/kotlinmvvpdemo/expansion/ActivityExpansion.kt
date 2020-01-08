package org.cchao.kotlintemplate.expansion

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.WindowManager
import com.core.frame.utils.ScreenUtils

/**
 * 获取屏幕高度
 */
fun Activity.getScreenHeight(): Int {
    return ScreenUtils.height(this).px
}

/**
 * 获取屏幕宽度
 */
fun Activity.getScreenWidth(): Int {
    return ScreenUtils.width(this).px
}

fun Activity.setFullscreen(fullscreen: Boolean) {
    val attrs = window.attributes
    if (fullscreen) {
        attrs.flags = attrs.flags and WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN.inv()
    } else {
        attrs.flags = attrs.flags or WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN
    }
    window.attributes = attrs
}

fun Activity.setFullScreen() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        val decorView = window.decorView
        decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                or View.SYSTEM_UI_FLAG_FULLSCREEN
                or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
    }
}
