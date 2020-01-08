package com.jjshouse.kotlinmvvpdemo

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import com.blankj.utilcode.util.LogUtils
import com.core.frame.utils.ToastUtils
import com.ethanhua.skeleton.SkeletonScreen
import com.jjshouse.kotlinmvvpdemo.base.BaseMvpActivity
import com.jjshouse.kotlinmvvpdemo.databinding.ActivitySecondBinding
import com.jjshouse.kotlinmvvpdemo.model.databean.HomeDataBean
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.SecondActivityContract
import com.jjshouse.kotlinmvvpdemo.mvvp.presenter.SecondeActivityPresenter

class SecondActivity : BaseMvpActivity<SecondeActivityPresenter>(), SecondActivityContract.View {

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
    }

    override fun initData() {
        mPresenter.getData()
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
        ToastUtils.showLong("点击forceCrash")
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
