package com.jjshouse.kotlinmvvpdemo.ui.activity

import android.view.View
import androidx.lifecycle.Observer
import com.core.frame.utils.ToastUtils
import com.jjshouse.kotlinmvvpdemo.BR
import com.jjshouse.kotlinmvvpdemo.R
import com.jjshouse.kotlinmvvpdemo.base.BaseMvvpActivity
import com.jjshouse.kotlinmvvpdemo.databinding.ActivityThirdBinding
import com.jjshouse.kotlinmvvpdemo.model.databean.HomeDataBean
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.SecondActivityContract
import com.jjshouse.kotlinmvvpdemo.mvvp.presenter.SecondeActivityPresenter
import com.jjshouse.kotlinmvvpdemo.mvvp.viewmodel.ThirdViewModel

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.ui.activity
 * Created by xbzhang on 2020/1/9
 * Description:
 *
 */
class ThirdActivity : BaseMvvpActivity<ActivityThirdBinding, ThirdViewModel, SecondeActivityPresenter>(),
    SecondActivityContract.View {
    private var data:HomeDataBean? = null

    override fun provideSuccessView(): Int {
        return R.layout.activity_third
    }

    override fun initVariableId(): Int {
        return BR.model
    }

    override fun inject() {
        getInjector().inject(this)
    }

    override fun initView() {

    }

    override fun initEvent() {

    }

    override fun initData() {
        mPresenter.getData()
    }

    override fun onTryAgain() {

    }

    override fun isMonitorNetWork(): Boolean {
        return false
    }

    override fun useDefaultToolBar(): Boolean {
        return true
    }

    override fun onGetDataSuccess(data: HomeDataBean) {
        ToastUtils.showShort("成功了")
        this.data = data
        mViewModel.data.value = data
    }

    override fun onGetDataError() {

    }

    override fun initViewObservable() {
        mViewModel.data.observe(this,
            Observer<HomeDataBean> { ToastUtils.showShort("数据有更新") })
    }

//    public fun forceCrash(view: View) {
//        this.data?.let {
//            it.banners[0].config[0].image = "https://cdn-4.jjshouse.com/upimg/jjshouse/o400/5c/00/896c89a9c40330b5c23165b4a52c5c00.jpg"
//            mViewModel.data.value = it
//        }
//    }
}