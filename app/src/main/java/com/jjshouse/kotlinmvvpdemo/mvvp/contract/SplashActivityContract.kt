package com.jjshouse.kotlinmvvpdemo.mvvp.contract

import com.jjshouse.kotlinmvvpdemo.model.databean.HomeDataBean
import com.jjshouse.kotlinmvvpdemo.model.databean.StartPageBean
import org.cchao.kotlintemplate.ui.base.BasePresenter
import org.cchao.kotlintemplate.ui.base.BaseView

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