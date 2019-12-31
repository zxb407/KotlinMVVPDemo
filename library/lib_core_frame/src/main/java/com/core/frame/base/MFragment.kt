package com.core.frame.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.core.frame.broadcast.ILocalBroadcastHandler
import com.core.frame.broadcast.LocalBroadcastHandlerImpl

/**
 * PackageName: com.core.frame.base
 * Created by xbzhang on 2019/12/31
 * Description:
 *
 */
open class MFragment:Fragment(), ILocalBroadcastHandler {

    lateinit var mLocalBroadcastHandler: ILocalBroadcastHandler

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mLocalBroadcastHandler = LocalBroadcastHandlerImpl(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onDetach() {
        super.onDetach()
        unRegisterAllLocalReceivers()
    }

    override val registeredReceivers: List<BroadcastReceiver>
        get() = mLocalBroadcastHandler.registeredReceivers //To change initializer of created properties use File | Settings | File Templates.

    override fun unRegisterAllLocalReceivers() {
        mLocalBroadcastHandler.unRegisterAllLocalReceivers() //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerLocalReceiver(receiver: BroadcastReceiver, filter: IntentFilter) {
        mLocalBroadcastHandler.registerLocalReceiver(receiver,filter) //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerLocalReceiver(receiver: BroadcastReceiver, vararg actions: String) {
        mLocalBroadcastHandler.registerLocalReceiver(receiver,actions) //To change body of created functions use File | Settings | File Templates.
    }

    override fun unRegisterLocalReceiver(receiver: BroadcastReceiver) {
        mLocalBroadcastHandler.unRegisterLocalReceiver(receiver) //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendLocalBroadcast(intent: Intent): Boolean {
        return mLocalBroadcastHandler.sendLocalBroadcast(intent) //To change body of created functions use File | Settings | File Templates.
    }

    override fun sendLocalBroadcastSync(intent: Intent) {
        mLocalBroadcastHandler.sendLocalBroadcastSync(intent) //To change body of created functions use File | Settings | File Templates.
    }
}