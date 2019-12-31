package com.core.frame.broadcast

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 */
interface ILocalBroadcastHandler {

    /**
     * Get all the [BroadcastReceiver] register in the [LocalBroadcastManager]
     *
     * @return [BroadcastReceiver]'s list.
     */
    val registeredReceivers: List<BroadcastReceiver>

    /**
     * Unregister all the [BroadcastReceiver] register in the [android.location.LocationManager]
     */
    fun unRegisterAllLocalReceivers()

    /**
     * See [LocalBroadcastManager.registerReceiver]
     *
     * @param receiver [BroadcastReceiver]
     * @param filter   [IntentFilter]
     */
    fun registerLocalReceiver(receiver: BroadcastReceiver, filter: IntentFilter)

    /**
     * See [LocalBroadcastManager.unregisterReceiver]
     *
     * @param receiver [BroadcastReceiver]
     * @param actions  string actions
     */
//    fun registerLocalReceiver(receiver: BroadcastReceiver, vararg actions: String)

    /**
     * See [LocalBroadcastManager.unregisterReceiver]
     *
     * @param receiver
     */
    fun unRegisterLocalReceiver(receiver: BroadcastReceiver)

    /**
     * See [LocalBroadcastManager.sendBroadcast]
     *
     * @param intent
     *
     * @return
     */
    fun sendLocalBroadcast(intent: Intent): Boolean

    /**
     * See [LocalBroadcastManager.sendBroadcastSync]
     *
     * @param intent
     */
    fun sendLocalBroadcastSync(intent: Intent)

    fun registerLocalReceiver(receiver: BroadcastReceiver, actions: Array<out String>)
}
