package com.jjshouse.kotlinmvvpdemo.mvvp.contract

import com.jjshouse.kotlinmvvpdemo.model.databean.HomeDataBean
import com.jjshouse.kotlinmvvpdemo.base.BasePresenter
import com.jjshouse.kotlinmvvpdemo.base.BaseView

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.mvvp.contract
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
interface SecondActivityContract {
    interface View : BaseView {
        fun onGetDataSuccess(data: HomeDataBean)
        fun onGetDataError()
    }

    interface Presenter : BasePresenter {
        fun getData()
    }
}