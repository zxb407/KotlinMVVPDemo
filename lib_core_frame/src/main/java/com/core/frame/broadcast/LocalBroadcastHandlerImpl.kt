package com.core.frame.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.location.LocationManager
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import java.util.LinkedList

/**
 * PackageName: com.core.frame
 * Created by xbzhang on 2019/12/26
 * Description:
 */
class LocalBroadcastHandlerImpl(private val mContext: Context) : ILocalBroadcastHandler {

    private val mReceivers: LinkedList<BroadcastReceiver> = LinkedList()

    /**
     * Get all the [BroadcastReceiver] register in the [LocalBroadcastManager]
     *
     * @return [BroadcastReceiver]'s list.
     */
    override val registeredReceivers: List<BroadcastReceiver>
        get() = mReceivers

    private fun getBroadcastManager(context: Context): LocalBroadcastManager {
        return LocalBroadcastManager.getInstance(context)
    }

    /**
     * Unregister all the [BroadcastReceiver] register in the [LocationManager]
     */
    @Synchronized
    override fun unRegisterAllLocalReceivers() {
        for (receiver in mReceivers) {
            getBroadcastManager(mContext).unregisterReceiver(receiver)
        }
        mReceivers.clear()
    }

    /**
     * See [LocalBroadcastManager.registerReceiver]
     *
     * @param receiver
     * @param filter
     */
    override fun registerLocalReceiver(receiver: BroadcastReceiver, filter: IntentFilter) {
        getBroadcastManager(mContext).registerReceiver(receiver, filter)
        mReceivers.add(receiver)
    }

    /**
     * See [LocalBroadcastManager.unregisterReceiver]
     *
     * @param receiver [BroadcastReceiver]
     * @param actions  string actions
     */
    override fun registerLocalReceiver(receiver: BroadcastReceiver, vararg actions: String) {
        val filter = IntentFilter()
        if (null != actions && actions.isNotEmpty()) {
            for (action in actions) {
                filter.addAction(action)
            }
        }
        getBroadcastManager(mContext).registerReceiver(receiver, filter)
        mReceivers.add(receiver)
    }

    /**
     * See [LocalBroadcastManager.unregisterReceiver]
     *
     * @param receiver
     */
    override fun unRegisterLocalReceiver(receiver: BroadcastReceiver) {
        getBroadcastManager(mContext).unregisterReceiver(receiver)
        mReceivers.remove(receiver)
    }

    /**
     * See [LocalBroadcastManager.sendBroadcast]
     *
     * @param intent
     *
     * @return
     */
    override fun sendLocalBroadcast(intent: Intent): Boolean {
        return getBroadcastManager(mContext).sendBroadcast(intent)
    }

    /**
     * See [LocalBroadcastManager.sendBroadcastSync]
     *
     * @param intent
     */
    override fun sendLocalBroadcastSync(intent: Intent) {
        getBroadcastManager(mContext).sendBroadcastSync(intent)
    }
}
