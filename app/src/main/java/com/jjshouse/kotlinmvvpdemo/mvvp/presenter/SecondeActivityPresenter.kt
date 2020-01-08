package com.jjshouse.kotlinmvvpdemo.mvvp.presenter

import com.core.frame.app.BaseApplication
import com.core.frame.utils.NetworkUtils
import com.jjshouse.kotlinmvvpdemo.model.mock.HomeDataMock
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.SecondActivityContract
import org.cchao.kotlintemplate.ui.base.BasePresenterImpl
import org.cchao.kotlintemplate.ui.base.BaseView
import javax.inject.Inject

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.mvvp.presenter
 * Created by xbzhang on 2020/1/3
 * Description:
 *
 */
class SecondeActivityPresenter
@Inject constructor(view: BaseView) : BasePresenterImpl<SecondActivityContract.View>(view),
    SecondActivityContract.Presenter {
    override fun getData() {
        if (!NetworkUtils.isConnected()) {
            getPresenterView()?.onGetDataError()
            return
        }
        Thread(Runnable {
            Thread.sleep(3000)
            BaseApplication.handler.post { getPresenterView()?.onGetDataSuccess(HomeDataMock.instance.getHomeData()) }
        }).start()
    }
}