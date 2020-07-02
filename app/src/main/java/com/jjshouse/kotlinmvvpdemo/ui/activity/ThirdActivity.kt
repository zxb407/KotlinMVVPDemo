package com.jjshouse.kotlinmvvpdemo.ui.activity

import androidx.lifecycle.Observer
import com.core.frame.utils.ToastUtils
import com.jjshouse.kotlinmvvpdemo.BR
import com.jjshouse.kotlinmvvpdemo.R
import com.jjshouse.kotlinmvvpdemo.base.BaseMvvpActivity
import com.jjshouse.kotlinmvvpdemo.databinding.ActivityThirdBinding
import com.jjshouse.kotlinmvvpdemo.model.databean.HomeDataBean
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.SecondActivityContract
import com.jjshouse.kotlinmvvpdemo.mvvp.presenter.SecondActivityPresenter
import com.jjshouse.kotlinmvvpdemo.mvvp.viewmodel.ThirdViewModel

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.ui.activity
 * Created by xbzhang on 2020/1/9
 * Description:
 *
 */
class ThirdActivity : BaseMvvpActivity<ActivityThirdBinding, ThirdViewModel, SecondActivityPresenter>(),
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
}