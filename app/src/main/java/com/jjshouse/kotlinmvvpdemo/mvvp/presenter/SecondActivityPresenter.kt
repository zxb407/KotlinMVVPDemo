package com.jjshouse.kotlinmvvpdemo.mvvp.presenter

import com.core.frame.app.BaseApplication
import com.core.frame.utils.NetworkUtils
import com.jjshouse.kotlinmvvpdemo.model.mock.HomeDataMock
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.SecondActivityContract
import com.jjshouse.kotlinmvvpdemo.base.BasePresenterImpl
import com.jjshouse.kotlinmvvpdemo.base.BaseView
import javax.inject.Inject

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.mvvp.presenter
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
class SecondActivityPresenter
@Inject constructor(view: BaseView) : BasePresenterImpl<SecondActivityContract.View>(view),
    SecondActivityContract.Presenter {
    override fun getData() {
        if (!NetworkUtils.isConnected()) {
            getPresenterView()?.onGetDataError()
            return
        }
        Thread(Runnable {
            Thread.sleep(300)
            BaseApplication.handler.post { getPresenterView()?.onGetDataSuccess(HomeDataMock.instance.getHomeData()) }
        }).start()
    }
}