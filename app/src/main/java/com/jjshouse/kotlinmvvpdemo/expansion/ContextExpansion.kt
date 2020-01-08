package org.cchao.kotlintemplate.expansion

import android.content.Context
import android.os.Build
import com.core.frame.utils.NetworkUtils
import com.jjshouse.kotlinmvvpdemo.JJApplication
import com.jjshouse.kotlinmvvpdemo.base.constants.AppConfig
import com.jjshouse.kotlinmvvpdemo.handle.URLManager
import com.jjshouse.kotlinmvvpdemo.utils.AppUtils
import org.cchao.http.RetrofitUtils


/**
 * 判断网络连接
 */
fun Context.isConnected(): Boolean {
    return NetworkUtils.isConnected()
}

fun Context.getAppComponent() = JJApplication.instance.appComponent

fun Context.setBaseUrl() {
    var http = AppConfig.HTTPS
    if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT) {
        http = AppConfig.HTTP
    }
    RetrofitUtils.BASE_URL = "$http${AppConfig.HOME}${getLangSuffix()}".trimEnd('/') + "/"
    URLManager.handleBaseAppUrl( RetrofitUtils.BASE_URL)
}

private fun getLangSuffix(): String {
    return "/${AppUtils.getUserLanguage()}"
}

