package com.jjshouse.kotlinmvvpdemo.ui.activity

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.graphics.drawable.TransitionDrawable
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.core.frame.utils.ToastUtils
import com.ethanhua.skeleton.SkeletonScreen
import com.jjshouse.kotlinmvvpdemo.base.BaseMvpActivity
import com.jjshouse.kotlinmvvpdemo.databinding.ActivitySecondBinding
import com.jjshouse.kotlinmvvpdemo.model.databean.HomeDataBean
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.SecondActivityContract
import com.jjshouse.kotlinmvvpdemo.mvvp.presenter.SecondActivityPresenter
import kotlinx.android.synthetic.main.activity_second.*


class SecondActivity : BaseMvpActivity<SecondActivityPresenter>(), SecondActivityContract.View {

    private var skeletonScreen: SkeletonScreen? = null
    lateinit var binding: ActivitySecondBinding

    override fun getSuccessView(): View {
        binding = ActivitySecondBinding.inflate(layoutInflater, null, false)
        binding.act = this
        return binding.root
    }

    override fun inject() {
        getInjector().inject(this)
    }

    override fun initView() {
        stateLayout.showLoadingViewAbove()
    }

    override fun initEvent() {
        iv_transition.setOnLongClickListener {
            if (iv_transition.drawable is TransitionDrawable) {
                (iv_transition.drawable as TransitionDrawable).reverseTransition(500)
            }
            true
        }
    }

    @SuppressLint("CheckResult")
    override fun initData() {
        mPresenter.getData()
        loadPic("https://cdn-4.jjshouse.com/upimg/jjshouse/o400/5c/00/896c89a9c40330b5c23165b4a52c5c00.jpg")
    }

    private fun loadPic(url: String) {
        Glide.with(this)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    iv_transition.setImageDrawable(resource)
                    loadSecondPic("https://cdn-1.jjshouse.com/upimg/jjshouse/o400/d4/8e/4be7551d875c52e8b4adb109f323d48e.jpg")
                    return true
                }
            })
            .into(iv_transition)
    }

    private fun loadSecondPic(url: String) {
        Glide.with(this)
            .load(url)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return true
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {

                    iv_transition.setImageDrawable(TransitionDrawable(arrayOf(iv_transition.drawable, resource)))
                    return true
                }
            })
            .preload()
    }

    override fun onTryAgain() {
        mPresenter.getData()
    }

    override fun isMonitorNetWork(): Boolean {
        return true
    }

    override fun useDefaultToolBar(): Boolean {
        return true
    }

    open fun forceCrash() {
        ToastUtils.showLong("点击图片")
    }

    open fun longClick(){

    }

    override fun onGetDataSuccess(data: HomeDataBean) {
        skeletonScreen?.hide()
        stateLayout.showSuccessView()
        binding.homeData = data
        ToastUtils.showLong("成功了")
    }

    override fun onGetDataError() {
        skeletonScreen?.hide()
        stateLayout.showErrorView()
    }
}
