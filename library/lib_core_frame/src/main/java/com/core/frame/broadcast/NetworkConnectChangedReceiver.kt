package com.core.frame.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import com.core.frame.Variables
import com.core.frame.model.NetWorkChangeEvent
import org.greenrobot.eventbus.EventBus

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 */
class NetworkConnectChangedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        if (networkInfo != null && networkInfo.isAvailable) {
            if (!state) {
                state = true
                Variables.NetworkType = when {
                    networkInfo.type == ConnectivityManager.TYPE_WIFI
                            || networkInfo.type == ConnectivityManager.TYPE_MOBILE -> networkInfo.type
                    else -> -1
                }
                EventBus.getDefault().post(NetWorkChangeEvent(true))
            }
        } else {
            if (state) {
                state = false
                Variables.NetworkType = -1
                EventBus.getDefault().post(NetWorkChangeEvent(false))
            }
        }

    }

    companion object {
        private val TAG = "NetworkChangedReceiver"
        private var state = true
    }
}
