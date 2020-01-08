package com.jjshouse.kotlinmvvpdemo.handle

import android.text.TextUtils
import android.webkit.URLUtil
import com.jjshouse.kotlinmvvpdemo.base.constants.AppConfig
import com.jjshouse.kotlinmvvpdemo.base.constants.Key
import io.fabric.sdk.android.services.network.UrlUtils
import org.cchao.http.RetrofitUtils
import java.util.regex.Pattern

object URLManager {

    val redirectURLs = mutableSetOf<String>()

    private val redirectCode = listOf(301, 302)
    private val TAG: String = "URLManager"

    var otherURLHasLoaded = false

    fun saveRedirectURL(url: String) {
        redirectURLs.add(url)
    }

    fun getImageUrl(url: String?): String {
        if (TextUtils.isEmpty(url)) {
            return ""
        }
        var imgsUrl = url!!
        when {
            imgsUrl.startsWith("https://") -> return imgsUrl
            imgsUrl.startsWith("http://") -> return imgsUrl
            imgsUrl.startsWith("//") -> return "http:$imgsUrl"
            imgsUrl.startsWith("/") -> imgsUrl = imgsUrl.substring(1)
        }
        return "http://$imgsUrl"
    }

    /**
     * 运营不同分辨率的商品图片
     */
    fun getImageUrl(url: String?, type: String): String {
        if (TextUtils.isEmpty(url)) {
            return ""
        }
        var imgsUrl = url!!
        when {
            imgsUrl.startsWith("https://") -> return imgsUrl
            imgsUrl.startsWith("http://") -> return imgsUrl
            imgsUrl.startsWith("//") -> return "http:$imgsUrl"
            imgsUrl.startsWith("/") -> imgsUrl = imgsUrl.substring(1)
        }
        var result = "https://imgs.veryvoga.com/$type/$imgsUrl"
        return result
    }

    /**
     * 运营推送图片
     */
    fun getOperationImageUrl(url: String?): String {
        if (TextUtils.isEmpty(url)) {
            return ""
        }
        var imgsUrl = url!!
        when {
            imgsUrl.startsWith("https://") -> imgsUrl = imgsUrl.substring(8)
            imgsUrl.startsWith("http://") -> imgsUrl = imgsUrl.substring(7)
            imgsUrl.startsWith("//") -> imgsUrl = imgsUrl.substring(2)
            imgsUrl.startsWith("/") -> imgsUrl = imgsUrl.substring(1)
        }
        var result = "https://imgs.veryvoga.com/v5res/$imgsUrl"
        return result
    }

    /**
     * 获取stylegallery图片
     */
    fun getTicketImageUrl(url: String?): String {
        if (TextUtils.isEmpty(url)) {
            return ""
        }
        var imgsUrl = url!!
        when {
            imgsUrl.startsWith("https://") -> return imgsUrl
            imgsUrl.startsWith("http://") -> return imgsUrl
            imgsUrl.startsWith("//") -> return "http:$imgsUrl"
            imgsUrl.startsWith("/") -> imgsUrl = imgsUrl.substring(1)
        }
        var result = "https://imgs.veryvoga.com/ticket/$imgsUrl"
        return result
    }

    fun getHost(url: String): String {
//        val host =  Pattern.compile("http.+//([^/]+)/?.*").matcher(url).replaceAll("$1")
//        var host1 = Pattern.compile("([^:]+):?.*").matcher(host).replaceAll("$1")
        var host: String = ""
        var matcher = Pattern.compile("//[^/]+/?").matcher(url)
        while (matcher.find()) {
            host = matcher.group()
            break
        }
        val host1 = Pattern.compile("//([^/]+)/?").matcher(host).replaceAll("$1")
        return if (host1 == url) "" else host1
    }

    fun shouldOverrideUrl(url: String): Boolean {
        return false
        //其他host的页面默认属于跳转url
        val matchUrlCount = redirectURLs.count { url in it || it in url }
        //保证其他host连接已经进入新页面
        return if (AppConfig.HOME == getHost(url)) !(matchUrlCount > 0) else !otherURLHasLoaded
    }

    fun isNeedLogin(url: String): Boolean {
        return getHost(url) == AppConfig.HOME &&
                url.contains("login", true) &&
                !url.contains("checkout_login", true)
    }

    fun isHomePage(url: String?): Boolean {

        if (TextUtils.isEmpty(url)) {
            false
        }

        val convertUrl = url?.replace("//", "/")
                ?.replace("#/", "")
        //无语言无参数的情况
        val regex1 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/?"
        //有语言无参数的情况
        val regex2 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/?"
        //无语言有参数
        val regex3 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/?\\?.*"
        //有语言有参数的情况
        val regex4 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/?\\?.*"

        if (Regex(regex1, RegexOption.IGNORE_CASE).matches(convertUrl!!) ||
                Regex(regex2, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex3, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex4, RegexOption.IGNORE_CASE).matches(convertUrl)) {
            return true
        }
        return false
    }

    fun isFavorite(url: String?): Boolean {
        //是favorite页面, 且不包含登陆信息
        var isFavorite = url?.contains("account/favorites.php", true) ?: false
        isFavorite = isFavorite && !(url?.contains("login", true) ?: false)
        return isFavorite
    }

    fun isCart(url: String?): Boolean {
        if (TextUtils.isEmpty(url)) {
            false
        }
        val convertUrl = url?.replace("//", "/")
                ?.replace("#/", "")
        //无语言无参数的情况
        val regex1 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/cart.php/?"
        //有语言无参数的情况
        val regex2 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/cart.php/?"
        //无语言有参数
        val regex3 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/cart.php\\?.*"
        //有语言有参数的情况
        val regex4 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/cart.php\\?.*"

        if (Regex(regex1, RegexOption.IGNORE_CASE).matches(convertUrl!!) ||
                Regex(regex2, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex3, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex4, RegexOption.IGNORE_CASE).matches(convertUrl)) {
            return true
        }
        return false
    }

    fun isCheckOutPage(url: String): String {
        var orderNumber: String = ""
        val regex = Regex("checkout.php\\?.*[&|?]?pre_order_sn=([a-zA-Z0-9\\.\\-\\_]+)&?", RegexOption.IGNORE_CASE)
        var results = regex.find(url)
        results?.let {
            for (kv in it.groupValues) {
                orderNumber = kv
            }
        }
        return orderNumber
    }

    fun isPaymentSuccess(url: String): String {
        var orderNumber: String = ""
        val regex = Regex("checkout_success.php\\?.*[&|?]?[order_sn|trackId]=([a-zA-Z0-9\\.\\-\\_]+)&?", RegexOption.IGNORE_CASE)
        var results = regex.find(url)
        results?.let {
            for (kv in it.groupValues) {
                orderNumber = kv
            }
        }
        return orderNumber
    }

    fun isOrderDetailPage(url: String): String {
        var orderNumber: String = ""
        val regex = Regex("order.php\\?.*[&|?]?order_sn=([a-zA-Z0-9\\.\\-\\_]+)&?", RegexOption.IGNORE_CASE)
        var results = regex.find(url)
        results?.let {
            for (kv in it.groupValues) {
                orderNumber = kv
            }
        }
        return orderNumber
    }

    fun isCreditPayPage(url: String): String {
        var orderNumber: String = ""
        val regex = Regex("pay_now.php\\?order_sn=([a-zA-Z0-9\\.\\-\\_]+)[#|&|//]?", RegexOption.IGNORE_CASE)
        var results = regex.find(url)
        results?.let {
            for (kv in it.groupValues) {
                orderNumber = kv
            }
        }
        return orderNumber
    }

    fun isOrderList(url: String): Boolean {
        if (TextUtils.isEmpty(url)) {
            false
        }
        val convertUrl = url?.replace("//", "/")
                ?.replace("#/", "")
        //无语言无参数的情况
        val regex1 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/account/orders.php/?"
        //有语言无参数的情况
        val regex2 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/account/orders.php/?"
        //无语言有参数
        val regex3 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/account/orders.php\\?.*"
        //有语言有参数的情况
        val regex4 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/account/orders.php\\?.*"

        if (Regex(regex1, RegexOption.IGNORE_CASE).matches(convertUrl!!) ||
                Regex(regex2, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex3, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex4, RegexOption.IGNORE_CASE).matches(convertUrl)) {
            return true
        }
        return false
    }

    fun isOrderDetail(url: String): Boolean {
        if (TextUtils.isEmpty(url)) {
            false
        }
        val convertUrl = url?.replace("//", "/")
                ?.replace("#/", "")
        //无语言无参数的情况
        val regex1 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/account/order.php/?"
        //有语言无参数的情况
        val regex2 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/account/order.php/?"
        //无语言有参数
        val regex3 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/account/order.php\\?.*"
        //有语言有参数的情况
        val regex4 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/account/order.php\\?.*"

        if (Regex(regex1, RegexOption.IGNORE_CASE).matches(convertUrl!!) ||
                Regex(regex2, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex3, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex4, RegexOption.IGNORE_CASE).matches(convertUrl)) {
            return true
        }
        return false
    }

    fun isOnlineForm(url: String): Boolean {
        if (TextUtils.isEmpty(url)) {
            false
        }
        val convertUrl = url?.replace("//", "/")
                ?.replace("#/", "")
        //无语言无参数的情况
        val regex1 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/about/email.php/?"
        //有语言无参数的情况
        val regex2 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/about/email.php/?"
        //无语言有参数
        val regex3 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/about/email.php\\?.*"
        //有语言有参数的情况
        val regex4 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/about/email.php\\?.*"

        if (Regex(regex1, RegexOption.IGNORE_CASE).matches(convertUrl!!) ||
                Regex(regex2, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex3, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex4, RegexOption.IGNORE_CASE).matches(convertUrl)) {
            return true
        }
        return false
    }

    fun ish5ProductListPage(url: String): String {
        var catId: String = ""
        val regex = Regex("-c([0-9]+)[#|&|//]?", RegexOption.IGNORE_CASE)
        var results = regex.find(url)
        results?.let {
            for (kv in it.groupValues) {
                catId = kv
            }
        }
        return catId
    }

    fun isLearnMorePage(url: String): Boolean {
        if (TextUtils.isEmpty(url)) {
            false
        }
        val convertUrl = url?.replace("//", "/")
                ?.replace("#/", "")
        //无语言有参数
        val regex3 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/about/help.php\\?page_id=84"
        //有语言有参数的情况\
        val regex4 = "https?:/[^.]+\\.${Key.HOST_KEY}\\.[^/]+/[a-z]{2}/about/help.php\\?page_id=84"

        if (Regex(regex3, RegexOption.IGNORE_CASE).matches(convertUrl) ||
                Regex(regex4, RegexOption.IGNORE_CASE).matches(convertUrl)) {
            return true
        }
        return false
    }

    fun queryOrderSn(url: String): String? {
        var orderSn: String? = null
        val queryParams = UrlUtils.getQueryParams(String(URLUtil.decode(url.toByteArray())), false)
        for ((key, value) in queryParams) {
            if (key.equals("trackId", true) || key.equals("order_sn", true)) {
                return value
            }
        }
        return orderSn
    }

    fun handleBaseAppUrl(url: String) {
        val regex = Regex("https?://[^\\.]+\\.[^\\.]+\\.([^/]+)/?.*"
                , RegexOption.IGNORE_CASE)
        var results = regex.find(url)
        results?.let {
            for ((i, v) in it.groupValues.withIndex()) {
                if (i > 0) {
                    RetrofitUtils.BASE_APP_URL = RetrofitUtils.BASE_APP_URL.replace(Regex("[^.]+$"), v) + "/"
                    break
                }
            }
        }
    }
}