package org.cchao.kotlintemplate.expansion

import android.content.Context
import com.core.frame.utils.NetworkUtils


/**
 * 判断网络连接
 */
fun Context.isConnected(): Boolean {
    return NetworkUtils.isConnected()
}

