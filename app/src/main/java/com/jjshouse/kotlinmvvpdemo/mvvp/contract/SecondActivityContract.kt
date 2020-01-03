package com.jjshouse.kotlinmvvpdemo.mvvp.contract

import org.cchao.kotlintemplate.ui.base.BasePresenter
import org.cchao.kotlintemplate.ui.base.BaseView

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.mvvp.contract
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
interface SecondActivityContract {
    interface View : BaseView {
        fun onGetDataSuccess()
        fun onGetDataError()
    }

    interface Presenter : BasePresenter {
        fun getData()
    }
}