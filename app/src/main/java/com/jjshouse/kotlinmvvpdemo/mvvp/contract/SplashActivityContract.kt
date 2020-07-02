package com.jjshouse.kotlinmvvpdemo.mvvp.contract

import com.jjshouse.kotlinmvvpdemo.model.databean.StartPageBean
import com.jjshouse.kotlinmvvpdemo.base.BasePresenter
import com.jjshouse.kotlinmvvpdemo.base.BaseView

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.mvvp.contract
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
interface SplashActivityContract {
    interface View : BaseView {
        fun onGetDataSuccess(data: StartPageBean)
        fun onGetDataError(msg:String)
    }

    interface Presenter : BasePresenter {
        fun getStartPage()
    }
}