package com.jjshouse.kotlinmvvpdemo

import android.Manifest
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import com.blankj.utilcode.util.LogUtils
import com.bumptech.glide.Glide
import com.core.frame.Variables
import com.core.frame.base.MToolbarActivity
import com.core.frame.model.NetWorkChangeEvent
import com.jjshouse.kotlinmvvpdemo.utils.glideutils.GlideUtil
import com.tbruyelle.rxpermissions2.RxPermissions
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class MainActivity : MToolbarActivity(), View.OnClickListener {

    companion object{
        const val KEY_PUSH = "key_push"
    }

    private var mDialog: Dialog? = null

    override fun useDefaultToolBar(): Boolean {
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        EventBus.getDefault().register(this)
        initView()
        initEvent()
    }

    private fun initView() {
        setupTitle("Home")
    }


    @SuppressLint("CheckResult")
    private fun initEvent() {
        bt_jump.setOnClickListener(this)

    }

    private fun showTip(type: Int) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("permission")
            .setMessage("点击允许才可以使用我们的app哦")
            .setPositiveButton("去允许") { dialog, id ->
                if (mDialog != null && mDialog?.isShowing == true) {
                    mDialog!!.dismiss()
                }
                when (type) {
                    1 -> {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        val uri = Uri.fromParts("package", packageName, null)//注意就是"package",不用改成自己的包名
                        intent.data = uri
                        startActivityForResult(intent, 0)
                    }
                    2 -> {
                        RxPermissions(this@MainActivity)
                            .requestEachCombined(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                            .subscribe { permission ->
                                when {
                                    permission.granted ->
                                        startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                                    permission.shouldShowRequestPermissionRationale -> showTip(2)
                                    else ->
                                        showTip(1)
                                }
                            }
                    }
                }
            }
        mDialog = builder.create()
        mDialog?.setCanceledOnTouchOutside(false)
        mDialog?.show()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun NetworkCallback(netWorkChangeEvent: NetWorkChangeEvent) {
        LogUtils.d("NetWorkStateMonitor", "${netWorkChangeEvent.isConnect}---${Variables.NetworkType}")
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.bt_jump -> {
                RxPermissions(this@MainActivity)
                    .requestEachCombined(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    .subscribe {
                        RxPermissions(this@MainActivity)
                            .requestEachCombined(
                                Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION
                            )
                            .subscribe { permission ->
                                when {
                                    permission.granted ->
                                        startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                                    permission.shouldShowRequestPermissionRationale -> showTip(2)
                                    else ->
                                        showTip(1)
                                }
                            }
                    }
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            0 -> {
                RxPermissions(this@MainActivity)
                    .requestEachCombined(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    )
                    .subscribe { permission ->
                        when {
                            permission.granted ->
                                startActivity(Intent(this@MainActivity, SecondActivity::class.java))
                            permission.shouldShowRequestPermissionRationale -> showTip(2)
                            else ->
                                showTip(1)
                        }
                    }
            }
        }
    }
}
