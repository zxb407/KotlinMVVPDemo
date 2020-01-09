package com.jjshouse.kotlinmvvpdemo.base

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.jjshouse.kotlinmvvpdemo.di.component.DaggerContractViewComponent
import com.jjshouse.kotlinmvvpdemo.di.module.IViewModule
import org.cchao.kotlintemplate.ui.base.BasePresenter
import org.cchao.kotlintemplate.ui.base.BaseView
import javax.inject.Inject

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.base
 * Created by xbzhang on 2019/12/31
 * Description:
 *
 */
abstract class BaseMvvpActivity<V : ViewDataBinding, VM : BaseViewModel, T : BasePresenter> : BaseStateActivity(),
    BaseView {

    lateinit var mBinding: V

    @Inject
    lateinit var mViewModel: VM

    @Inject
    lateinit var mPresenter: T

    override fun initComponentBuilder() {
        super.initComponentBuilder()
        activityComponentBuilder.contractViewComponent(
            DaggerContractViewComponent.builder().iViewModule(
                IViewModule(
                    this
                )
            ).build()
        ).build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewObservable()
    }

    override fun getSuccessView(): View {
        mBinding = DataBindingUtil.inflate(layoutInflater, provideSuccessView(), null, false)
        mBinding.setVariable(initVariableId(), mViewModel)
        mBinding.executePendingBindings()
        //liveData绑定activity，fragment生命周期
        mBinding.lifecycleOwner = this
        return mBinding.root
    }

    abstract fun initViewObservable()

    abstract fun provideSuccessView(): Int

    abstract fun initVariableId(): Int

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
        mViewModel.onDestroy()
    }
}