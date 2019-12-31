package org.cchao.kotlintemplate.expansion

import android.app.Activity
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
