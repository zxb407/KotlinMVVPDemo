package com.jjshouse.kotlinmvvpdemo.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.PixelFormat
import android.os.Bundle
import android.provider.Settings
import android.view.*
import android.widget.ImageButton
import com.core.frame.base.MToolbarActivity
import com.core.frame.model.NetWorkChangeEvent
import com.core.frame.utils.UIUtils
import com.jjshouse.kotlinmvvpdemo.R
import com.jjshouse.kotlinmvvpdemo.di.component.ActivityComponent
import com.jjshouse.kotlinmvvpdemo.di.component.DaggerActivityComponent
import com.jjshouse.kotlinmvvpdemo.di.component.DaggerContractViewComponent
import com.jjshouse.kotlinmvvpdemo.di.module.ActivityModule
import com.jjshouse.kotlinmvvpdemo.di.module.IViewModule
import com.jjshouse.kotlinmvvpdemo.utils.AppUtils
import org.cchao.kotlintemplate.expansion.getAppComponent
import org.cchao.kotlintemplate.ui.base.BaseView
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.base
 * Created by xbzhang on 2019/12/31
 * Description:
 *
 */
abstract class BaseActivity : MToolbarActivity(),BaseView{

    private val TAG = this.javaClass.simpleName
    private var backPressedListener: BackPressedListener? = null
    lateinit var activityComponentBuilder: DaggerActivityComponent.Builder

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(JJContextWrapper.wrap(newBase, AppUtils.getUserLanguage()))
    }

//    /**
//     * User can override the default ToolbarLayout {@link sdk_base_toolbar_activity}
//     *
//     */
//    override fun onCreateToolbarLayout(inflater: LayoutInflater): ViewGroup {
//        return super.onCreateToolbarLayout(inflater)
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponentBuilder()
        inject()
        EventBus.getDefault().register(this)
        initLayout()
        if (isMonitorNetWork()) {
            initTipView()
        }
        initView()
        initEvent()
        initData()
    }

    open fun initComponentBuilder() {
        activityComponentBuilder = DaggerActivityComponent.builder().activityModule(ActivityModule(this))
            .appComponent(getAppComponent()).contractViewComponent(DaggerContractViewComponent.builder().iViewModule(
                IViewModule(this)
            ).build())
    }

    fun getInjector(): ActivityComponent {
        return activityComponentBuilder.build()
    }

    abstract fun inject()

    abstract fun initLayout()

    abstract fun initView()

    abstract fun initEvent()

    abstract fun initData()

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this)
    }
    // =============================================== BackPressListener ======================================

    fun setBackPressedListener(backPressedListener: BackPressedListener) {
        this.backPressedListener = backPressedListener
    }

    interface BackPressedListener {
        fun onBackPressed(activity: Activity): Boolean
    }

    // =============================================== Network state callBack ======================================

    private var mTipView: View? = null
    lateinit var mWindowManager: WindowManager
    lateinit var mLayoutParams: WindowManager.LayoutParams

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onNetChangeEvent(networkChangeEvent: NetWorkChangeEvent) {
        hasNetWork(networkChangeEvent.isConnect)
    }

    private fun initTipView() {
        mTipView = layoutInflater.inflate(R.layout.layout_network_disconnection_prompt, null) //提示View布局
        mWindowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        mLayoutParams = WindowManager.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,
            WindowManager.LayoutParams.TYPE_APPLICATION,
            WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        )
        mLayoutParams.gravity = Gravity.TOP
        mLayoutParams.y = UIUtils.dp2px(48)
        var goSetting = mTipView?.findViewById<ImageButton>(R.id.ib_setting)
        goSetting?.setOnClickListener {
            startActivity(Intent(Settings.ACTION_SETTINGS))
        }
    }

    private fun hasNetWork(has: Boolean) {
        if (isMonitorNetWork()) {
            if (has) {
                if (mTipView != null && mTipView?.parent != null) {
                    mWindowManager.removeView(mTipView)
                }
                onTryAgain()
            } else {
                if (mTipView?.parent == null) {
                    mWindowManager.addView(mTipView, mLayoutParams)
                }
            }
        }
    }

    abstract fun onTryAgain()

    abstract fun isMonitorNetWork(): Boolean
}