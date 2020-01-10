package com.jjshouse.kotlinmvvpdemo.utils

import android.app.ActivityManager
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.text.TextUtils
import android.view.View
import androidx.annotation.RequiresApi
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.GoogleApiAvailability
import com.jjshouse.kotlinmvvpdemo.JJApplication
import com.jjshouse.kotlinmvvpdemo.base.constants.Key
import org.json.JSONObject
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.text.ParseException
import java.util.*

object AppUtils {

    fun getUserLanguage(): String {
        var lang: String = SPUtils.getString(Key.USER_LANGUAGE)
        if (lang.isNotEmpty()) {
            return lang
        }
        return Key.USER_DEFAULT_LANGUAGE
    }

    fun getUserCurrency(): String {
        var cur: String = SPUtils.getString(Key.USER_CURRENCY)
        if (cur.isNotEmpty()) {
            return cur
        }
        return Key.USER_DEFAULT_CURRENCY
    }

    fun setUserCurrency(cur: String) {
        SPUtils.putString(Key.USER_CURRENCY, cur)
    }

    fun setUserLanguage(lang: String) {
        SPUtils.putString(Key.USER_LANGUAGE, lang)
    }

    fun setUserLanguageFullName(lang: String) {
        SPUtils.putString(Key.USER_LANGUAGE_FULL_NAME, lang)
    }

    fun getUserLanguageFullName(): String {
        return SPUtils.getString(Key.USER_LANGUAGE_FULL_NAME)
    }

    fun setUserCountryId(id: String) {
        SPUtils.putString(Key.USER_COUNTRY_UCID, id)
    }

    fun getUserCountryId(): String {
        return SPUtils.getString(Key.USER_COUNTRY_UCID)
    }

    fun setLocalHost(url:String){
        SPUtils.putString(Key.LOCAL_HOST,url)
    }

    fun getLocalHost():String{
        return SPUtils.getString(Key.LOCAL_HOST)
    }

    fun getUserCountry(): String {
        var country: String = SPUtils.getString(Key.USER_COUNTRY)
        if (country != null && !"".equals(country)) {
            return country
        }
        return Key.USER_DEFAULT_COUNTRY
    }

    fun setUserCountry(country: String) {
        SPUtils.putString(Key.USER_COUNTRY, country)
    }

    fun getString(resId: Int) {
        JJApplication.instance.getString(resId)
    }

    fun addLaunchCount() {
        var count = getLaunchCount()
        SPUtils.putInt(Key.USER_LAUNCH_COUNT, (count + 1))
    }

    fun getLaunchCount(): Int {
        var count = SPUtils.getInt(Key.USER_LAUNCH_COUNT)
        return if (count != null && count > 0) count else 0
    }

    /*
    * get app name
    */
    fun getVersionName(context: Context): String? {
        var versionName: String? = null
        try {
            val pm = context.getPackageManager()
            val info = pm.getPackageInfo(context.getPackageName(), 0)
            versionName = info.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }
        return versionName
    }

    /*
     * get app version
     */
    fun getVersionCode(context: Context): Int {

        var versionCode = 0
        try {
            val pm = context.getPackageManager()
            val info = pm.getPackageInfo(context.getPackageName(), 0)
            versionCode = info.versionCode
        } catch (e: PackageManager.NameNotFoundException) {
            // TODO Auto-generated catch block
            e.printStackTrace()
        }

        return versionCode
    }

    fun getSysLocale(context: Context): Locale {
        var config = context.resources.configuration
        var sysLocale: Locale? = null
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            sysLocale = config.locales.get(0)
        } else {
            sysLocale = config.locale
        }
        return sysLocale
    }

    fun getPlayServicesAvailableResult(context: Context): String {
        val googleApiAvailability = GoogleApiAvailability.getInstance()
        val resultCode = googleApiAvailability.isGooglePlayServicesAvailable(context)
        return ConnectionResult(resultCode).toString()
    }

    fun isPkgInstalled(context: Context, packageName: String): Boolean {
        if (packageName.isEmpty())
            return false
        var info: android.content.pm.ApplicationInfo? = null
        return try {
            info = context.packageManager.getApplicationInfo(packageName, 0)
            info != null
        } catch (e: PackageManager.NameNotFoundException) {
            false
        }
    }

//    fun jumpH5(context: Context, url: String?) {
//        var intent: Intent? = null
//        if (!url.isNullOrEmpty()) {
//            intent = Intent(context, WebActivity::class.java)
//            if (context !is Activity) {
//                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            }
//            intent.putExtra(Web.WEB_URL, url)
//        } else {
//            intent = Intent(context, MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
//            intent.putExtra("TAG", MainActivity.TAG_FRAGMENT_HOME)
//        }
//        context.startActivity(intent!!)
//    }

//    fun jumpNative(context: Context, url: String?, data: NativeConfig?) {
//        data?.let {
//            if (it.type == 4) {
//                jumpH5(context, url)
//            } else if (it.type < 3) {
//                var intent = Intent(context, ProductListActivity::class.java)
//                intent.putExtra("config", it)
//                context.startActivity(intent)
//            }
//        }
//    }

    fun setLoginStatus(status: Boolean) {
        SPUtils.putBoolean(Key.USER_LOGIN_STATUS, status)
    }

    fun setAccountInfo(data: String) {
        SPUtils.putString(Key.ACCOUNT_INFO, data)
    }

    fun getAccountInfo(): String {
        return SPUtils.getString(Key.ACCOUNT_INFO)
    }

    fun getLoginStatus(): Boolean {
        return try {
            SPUtils.getBoolean(Key.USER_LOGIN_STATUS)
        } catch (e: ClassCastException) {
            SPUtils.getString(Key.USER_LOGIN_STATUS) == "true"
        } catch (e: Exception) {
            false
        }
    }

//    fun getConversionPrice(value: Double, formatRules: CurrencyFormatRules, priceDecimlRz: Int): String {
//        Locale.setDefault(Locale.US)
//        var value = specialHandleFromUSD(value, priceDecimlRz)
//        value = if (formatRules.ceil > 0) Math.ceil(value) else value
//        var value1 = number_format(value, formatRules.decimals, formatRules.decPoint, formatRules.thousandsSep)
//        var symbol = formatRules.symbol
//        var space = if (formatRules.noWhiteSpace > 0) "" else " "
//        return if (formatRules.amountFirst > 0) {
//            "$value1$space$symbol"
//        } else {
//            "$symbol$space$value1"
//        }
//    }

//    fun getNumFormat(value: Double, formatRules: CurrencyFormatRules): String {
//        Locale.setDefault(Locale.US)
//        var value1 = number_format(value, formatRules.decimals, formatRules.decPoint, formatRules.thousandsSep)
//        var symbol = formatRules.symbol
//        var space = if (formatRules.noWhiteSpace > 0) "" else " "
//        return if (formatRules.amountFirst > 0) {
//            "$value1$space$symbol"
//        } else {
//            "$symbol$space$value1"
//        }
//    }

    fun number_format(value: Double, decimalcount: Int, point: String, sep: String): String {
        var numStr = value.toString()
        if (value.toString().isEmpty()) {
            return numStr
        }
        var unusualSymbols = DecimalFormatSymbols()
        val nf = NumberFormat.getInstance()
        var pattern = "#,##0"
        if (sep.isEmpty()) {
            pattern = "###0"
        } else {
            unusualSymbols.groupingSeparator = sep.toCharArray()[0]
        }
        if (point.isNotEmpty()) {
            unusualSymbols.decimalSeparator = point.toCharArray()[0]
        }

        if (decimalcount > 0) pattern += "."
        var count = decimalcount
        while (count > 0) {
            pattern += "0"
            count--
        }
        try {
            val df = DecimalFormat(pattern, unusualSymbols)
            numStr = df.format(nf.parse(value.toString()))
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return numStr
    }

    private fun specialHandleFromUSD(value: Double, priceDecimlRz: Int): Double {
        var amount = value
        when (getUserCurrency()) {
            "PLN" -> {
                amount = number_format(value, 2, ".", "").toDouble()
                var intPart = Math.floor(amount).toInt()
                var floatPart: Int = (amount * 100 % 100).toInt()
                if (floatPart < 40) {
                    floatPart = 0
                } else if (floatPart in 40.0..90.0) {
                    floatPart = 90
                } else if (floatPart > 90) {
                    floatPart = 99
                }
                amount = number_format("$intPart.$floatPart".toDouble(), 2, ".", "").toDouble()
            }
        }
        if (priceDecimlRz > 0) {
            if (Math.abs(value) > 5) {
                var sign = if (amount < 0) -1 else 1
                amount = Math.round(Math.abs(amount)) * sign.toDouble()
            }
        }
        return amount
    }

    fun jsonToMap(json: String): MutableMap<String, Int> {
        var map: MutableMap<String, Int> = mutableMapOf()
        if (TextUtils.isEmpty(json)) return map
        var jsonObject = JSONObject(json)
        var it = jsonObject.keys()
        // 遍历jsonObject数据，添加到Map对象
        while (it.hasNext()) {
            var key = it.next().toString()
            var value = jsonObject.getInt(key)
            map[key] = value
        }
        return map
    }

    fun getScreenLocation(v: View): IntArray {
        var location = IntArray(2)
        v.getLocationOnScreen(location)
        return location
    }

    fun setUserInfo(data: String) {
        SPUtils.putString(Key.USER_INFO, data)
    }

    fun getUserInfo(): String {
        return SPUtils.getString(Key.USER_INFO)
    }
}