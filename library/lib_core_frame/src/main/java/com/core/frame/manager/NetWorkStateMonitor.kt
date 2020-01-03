package com.core.frame.manager

import android.app.Application
import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.content.IntentFilter
import android.net.*
import android.net.wifi.WifiManager
import android.os.Build
import com.core.frame.app.BaseApplication
import com.core.frame.Variables
import com.core.frame.broadcast.NetworkConnectChangedReceiver
import com.core.frame.model.NetWorkChangeEvent
import org.greenrobot.eventbus.EventBus


/**
 * PackageName: com.core.frame.manager
 * Created by xbzhang on 2019/12/30
 * Description:
 *
 */
class NetWorkStateMonitor private constructor() {

    companion object {
        private var instance: NetWorkStateMonitor? = null
        val TAG = "NetWorkStateMonitor"
        private var state = false
        fun init(application: Application): NetWorkStateMonitor {
            if (instance == null) {
                instance =
                    NetWorkStateMonitor()
                registNetworkCallBack(application)
            }
            return instance as NetWorkStateMonitor
        }

        private fun registNetworkCallBack(context: Application) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                val manager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
                manager.requestNetwork(NetworkRequest.Builder().build(),
                    object : ConnectivityManager.NetworkCallback() {
                        override fun onAvailable(network: Network) {
                            super.onAvailable(network)
//                            LogUtils.dTag(TAG, "network is available")
                            BaseApplication.handler.postDelayed({
                                EventBus.getDefault().post(NetWorkChangeEvent(true))
                            }, 300)
                        }

                        override fun onLost(network: Network) {
                            super.onLost(network)
//                            LogUtils.dTag(TAG, "network is lost")
                            Variables.NetworkType = -1
                            EventBus.getDefault().post(NetWorkChangeEvent(false))
                        }

                        override fun onCapabilitiesChanged(network: Network, networkCapabilities: NetworkCapabilities) {
                            super.onCapabilitiesChanged(network, networkCapabilities)
//                            LogUtils.dTag(TAG, "onCapabilitiesChanged----${networkCapabilities.toString()}")
                            Variables.NetworkType =
                                when {
                                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> NetworkCapabilities.TRANSPORT_CELLULAR
                                    networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> NetworkCapabilities.TRANSPORT_WIFI
                                    else -> -1
                                }
                        }
                    })
            } else {
                var netWorkReceiver = NetworkConnectChangedReceiver()
                val filter = IntentFilter()
                filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
                context.registerReceiver(netWorkReceiver, filter)
            }
        }

        operator fun get(application: Application): NetWorkStateMonitor? {
            if (instance == null) {
                init(application)
            }
            return instance
        }

        operator fun get(ctx: Context): NetWorkStateMonitor {
            if (instance == null) {
                val appCtx = ctx.applicationContext
                if (appCtx is Application) {
                    init(appCtx)
                }
                throw IllegalStateException(
                    "Foreground is not initialised and " + "cannot obtain the Application object"
                )
            }
            return instance as NetWorkStateMonitor
        }

        fun get(): NetWorkStateMonitor {
            if (instance == null) {
                throw IllegalStateException(
                    "Foreground is not initialised - invoke " + "at least once with parameterised init/get"
                )
            }
            return instance as NetWorkStateMonitor
        }
    }
}