package com.jjshouse.kotlinmvvpdemo

import android.os.Bundle
import android.view.View
import com.core.frame.utils.ToastUtils
import com.ethanhua.skeleton.Skeleton
import com.ethanhua.skeleton.SkeletonScreen
import com.jjshouse.kotlinmvvpdemo.base.BaseMvpActivity
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.SecondActivityContract
import com.jjshouse.kotlinmvvpdemo.mvvp.presenter.SecondeActivityPresenter
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : BaseMvpActivity<SecondeActivityPresenter>(), SecondActivityContract.View {

    private var skeletonScreen: SkeletonScreen? = null

    override fun getSuccessView(): View {
        return View.inflate(this, R.layout.activity_second, null)
    }

//    override fun getLoadingView(): View? {
//        return View.inflate(this, R.layout.skeleton_activity_product_detail, null)
//    }

    override fun inject() {
        getInjector().inject(this)
    }

    override fun initView() {
        stateLayout.showSuccessView()
        skeletonScreen = Skeleton.bind(cs_root)
            .load(R.layout.skeleton_activity_product_detail)
            .duration(800)
            .color(R.color.shimmer_color)
            .angle(20)
            .show()
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    public fun forceCrash(view: View) {
//        mPresenter.getData()
    }

    override fun onGetDataSuccess() {
        stateLayout.showSuccessView()
        skeletonScreen?.hide()
        ToastUtils.showLong("成功了")
    }

    override fun onGetDataError() {
        skeletonScreen?.hide()
        stateLayout.showErrorView()
    }
}
