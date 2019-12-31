package com.core.frame.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.util.Log

object NetworkUtils {

    /**
     * 是否有网络连接
     *
     * @return
     */
    fun isNetworkAvailable(context: Context): Boolean {
        val connectivity = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivity != null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val capabilities = connectivity.getNetworkCapabilities(connectivity.activeNetwork)
                capabilities?.let {
                    return when {
                        it.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                        it.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                        else -> false
                    }
                }
            } else {
                try {
                    val activeNetworkInfo = connectivity.activeNetworkInfo
                    if (activeNetworkInfo != null && activeNetworkInfo!!.isAvailable) {
                        Log.i("update_statut", "Network is available : true")
                        return true
                    }
                } catch (e: Exception) {
                    Log.i("update_statut", "" + e.message)
                }

            }
        }
        return false
    }
}
