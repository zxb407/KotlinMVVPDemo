package com.core.frame.base

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.blankj.utilcode.util.AppUtils
import com.blankj.utilcode.util.LogUtils
import com.core.frame.R
import com.core.frame.broadcast.ILocalBroadcastHandler
import com.core.frame.broadcast.LocalBroadcastHandlerImpl
import com.core.frame.toolbar.ToolbarHandlerImpl

/**
 * PackageName: com.core.frame.base
 * Created by xbzhang on 2019/12/30
 * Description:
 *
 */
open class MActivity : AppCompatActivity(), ILocalBroadcastHandler {

    lateinit var mLocalBroadcastHandler: ILocalBroadcastHandler
    open var mToolbar: Toolbar? = null
    private var mToolbarHandler: ToolbarHandlerImpl? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLocalBroadcastHandler = LocalBroadcastHandlerImpl(this)
        mToolbarHandler = ToolbarHandlerImpl()
    }

    override fun onDestroy() {
        super.onDestroy()
        unRegisterAllLocalReceivers()
    }

    override val registeredReceivers: List<BroadcastReceiver>
        get() = mLocalBroadcastHandler.registeredReceivers //To change initializer of created properties use File | Settings | File Templates.

    override fun unRegisterAllLocalReceivers() {
        mLocalBroadcastHandler.unRegisterAllLocalReceivers() //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerLocalReceiver(receiver: BroadcastReceiver, filter: IntentFilter) {
        mLocalBroadcastHandler.registerLocalReceiver(
            receiver,
            filter
        ) //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerLocalReceiver(receiver: BroadcastReceiver, vararg actions: String) {
        mLocalBroadcastHandler.registerLocalReceiver(
            receiver,
            actions
        ) //To change body of created functions use File | Settings | File Templates.
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

    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
        setupToolbar(this, findViewById(R.id.toolbar))
    }

    override fun setContentView(view: View?) {
        super.setContentView(view)
        setupToolbar(this, findViewById(R.id.toolbar))
    }

    override fun setContentView(view: View?, params: ViewGroup.LayoutParams?) {
        super.setContentView(view, params)
        setupToolbar(this, findViewById(R.id.toolbar))
    }


    open fun setupToolbar(appCompatActivity: AppCompatActivity, toolbar: Toolbar?) {
        mToolbar = toolbar
        if (null != mToolbar) {
            mToolbarHandler?.setupToolbar(appCompatActivity, toolbar!!)
        } else {
            LogUtils.dTag("sdk", "Forget to setup your custom toolbar with id 'toolbar' ???")
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (mToolbarHandler?.onOptionsItemSelected(item) == true) {
            true
        } else super.onOptionsItemSelected(item)

    }

    open fun setupTitle(title: CharSequence) {
        supportActionBar?.let {
            it.title = title
        }
    }

    open fun setupTitle(title: Int) {
        setupTitle(getString(title))
    }
}