package com.jjshouse.kotlinmvvpdemo.base.constants

import android.text.TextUtils
import com.jjshouse.kotlinmvvpdemo.BuildConfig
import com.jjshouse.kotlinmvvpdemo.utils.AppUtils

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.base.constants
 * Created by xbzhang on 2020/1/7
 * Description:
 *
 */
object AppConfig {
    val HTTP = "http://"
    val HTTPS = "https://"
    var HOME: String = BuildConfig.BASE_URL
        get() {
            val cacheHome = AppUtils.getLocalHost()
            if (TextUtils.isEmpty(cacheHome)) {
                return field
            }
            return cacheHome
        }
        set(value) {
            if (HOME == value) {
                return
            }
            field = value
        }

    val sites = setOf("en", "de", "fr", "es", "se", "no", "it", "pt", "da", "fi", "nl", "pl", "cs", "ro", "hu", "el", "tr", "ru", "uk" )
    val DEEP_LINK_SCHEME = "${BuildConfig.DOMAIN}://"
}