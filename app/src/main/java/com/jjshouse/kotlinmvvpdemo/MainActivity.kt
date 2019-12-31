package com.jjshouse.kotlinmvvpdemo

import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.core.frame.Variables
import com.core.frame.base.BaseActivity
import com.core.frame.model.NetWorkChangeEvent
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun NetworkCallback(netWorkChangeEvent: NetWorkChangeEvent) {
        LogUtils.d("NetWorkStateMonitor", "${netWorkChangeEvent.isConnect}---${Variables.NetworkType}")
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    public fun jump(view: View) {
        startActivity(Intent(this@MainActivity, SecondActivity::class.java))
    }
}
