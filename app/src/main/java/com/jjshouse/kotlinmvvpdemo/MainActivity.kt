package com.jjshouse.kotlinmvvpdemo

import android.os.Bundle
import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.core.frame.Variables
import com.core.frame.base.MToolbarActivity
import com.core.frame.model.NetWorkChangeEvent
import com.core.frame.utils.ToastUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.cchao.kotlintemplate.expansion.click
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : MToolbarActivity() ,View.OnClickListener{
    override fun useDefaultToolBar(): Boolean {
        return false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        initEvent()
    }



    private fun initEvent() {
        bt_jump.click(this)
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

    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.bt_jump ->{
                ToastUtils.showLong("adfefefe")
//                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
            }
        }

    }
}
