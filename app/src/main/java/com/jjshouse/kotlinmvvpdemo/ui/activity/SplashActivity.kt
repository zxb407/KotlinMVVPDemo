package com.jjshouse.kotlinmvvpdemo.ui.activity

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Handler
import android.os.Message
import android.text.TextUtils
import android.view.View
import android.view.animation.AlphaAnimation
import com.blankj.utilcode.util.ScreenUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.core.frame.utils.jsonutils.JsonUtils
import com.jjshouse.kotlinmvvpdemo.R
import com.jjshouse.kotlinmvvpdemo.base.BaseMvpActivity
import com.jjshouse.kotlinmvvpdemo.handle.URLManager
import com.jjshouse.kotlinmvvpdemo.model.databean.MessageBean
import com.jjshouse.kotlinmvvpdemo.model.StartPageBean
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.SplashActivityContract
import com.jjshouse.kotlinmvvpdemo.mvvp.presenter.SplashActivityPresenter
import com.jjshouse.kotlinmvvpdemo.utils.UtilsBigDecimal
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.layout_activity_splash.*
import org.cchao.kotlintemplate.expansion.setBaseUrl

/**
 * PackageName: com.dding.mvpdemo.ui.activity
 * Created by xbzhang on 2019/1/8
 * Description: 开机图Activity, 启动入口
 */
class SplashActivity : BaseMvpActivity<SplashActivityPresenter>(), SplashActivityContract.View, Handler.Callback {

    private val WHAT_CLOSE = 1
    private val WHAT_COUNTDOWN = 2
    private var time: Int = 3
    private lateinit var mHandler: Handler
    private var disposable: Disposable? = null
    private var messageBean: MessageBean? = null
    private var doAnimation = false

    override fun getSuccessView(): View {
        return View.inflate(this, R.layout.layout_activity_splash, null)
    }

    override fun inject() {
        getInjector().inject(this)

    }

    override fun onTryAgain() {

    }

    override fun isMonitorNetWork(): Boolean {
        return false
    }

    override fun initView() {
        setFullScreen()
        mHandler = Handler(this)
        mHandler.sendEmptyMessageDelayed(WHAT_CLOSE, 5000)
    }

    override fun initEvent() {
        tv_splash_jump.setOnClickListener {
            mHandler.removeMessages(WHAT_CLOSE)
            mHandler.removeMessages(WHAT_COUNTDOWN)
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            if (null != messageBean) {
                intent.putExtra(MainActivity.KEY_PUSH, JsonUtils.toString(messageBean!!))
            }
            startActivity(intent)
            finish()
        }
    }

    override fun useDefaultToolBar(): Boolean {
        return false
    }

    override fun initData() {
        setBaseUrl()
        mPresenter.getStartPage()
    }

    override fun handleMessage(msg: Message?): Boolean {
        if (msg!!.what == WHAT_CLOSE) {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            if (null != messageBean) {
                intent.putExtra(MainActivity.KEY_PUSH, JsonUtils.toString(messageBean!!))
            }
            startActivity(intent)
            finish()
            return false
        }
        if (time > 0) {
            tv_splash_jump.text = String.format(resources.getString(R.string.splash_jump), time.toString())
            mHandler.sendEmptyMessageDelayed(WHAT_COUNTDOWN, 1000)
        } else {
            val intent = Intent(this@SplashActivity, MainActivity::class.java)
            if (null != messageBean) {
                intent.putExtra(MainActivity.KEY_PUSH, JsonUtils.toString(messageBean!!))
            }
            startActivity(intent)
            finish()
        }
        time--
        return false
    }

    override fun onGetDataSuccess(t: StartPageBean) {
        var imgUrl = handleImageUrl(t.img_url ?: "")
        Glide.with(this@SplashActivity).load(URLManager.getImageUrl(imgUrl))
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(object : SimpleTarget<Drawable>() {
                override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                    iv_splash.setImageDrawable(resource)
                    startAlphaAnimation()
                    mHandler.removeMessages(WHAT_CLOSE)
                    mHandler.removeMessages(WHAT_COUNTDOWN)
                    mHandler.sendEmptyMessage(WHAT_COUNTDOWN)
                    tv_splash_jump.visibility = View.VISIBLE
                }
            })
    }

    private fun startAlphaAnimation() {
        if (!doAnimation) {
            var animation = AlphaAnimation(0f, 1f)
            animation.duration = 800
            iv_splash.startAnimation(animation)
            doAnimation = true
        }
    }

    override fun onGetDataError(msg: String) {
        Glide.with(this@SplashActivity).load(R.drawable.ic_splash_bg).into(object : SimpleTarget<Drawable>() {
            override fun onResourceReady(resource: Drawable, transition: Transition<in Drawable>?) {
                iv_splash.setImageDrawable(resource)
                startAlphaAnimation()
                mHandler.removeMessages(WHAT_CLOSE)
                mHandler.sendEmptyMessage(WHAT_COUNTDOWN)
                tv_splash_jump.visibility = View.VISIBLE
            }
        })
    }

    private fun handleImageUrl(s: String): String {
        if (TextUtils.isEmpty(s)) return ""
        var imgUrl = s
        var ratio =
            UtilsBigDecimal.div(ScreenUtils.getScreenHeight().toDouble(), ScreenUtils.getScreenWidth().toDouble())
                .toFloat()
        imgUrl = if (ratio > 0 && ratio <= 1.78f) {
            imgUrl.replace(Regex("boot_[^.]*"), "boot_1")
        } else if (ratio > 1.78f && ratio <= 2.06) {
            imgUrl.replace(Regex("boot_[^.]*"), "boot_2")
        } else {
            imgUrl.replace(Regex("boot_[^.]*"), "boot_3")
        }
        return imgUrl
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandler.removeMessages(WHAT_CLOSE)
        mHandler.removeMessages(WHAT_COUNTDOWN)
        disposable?.let {
            it.dispose()
        }
    }
}