package com.jjshouse.kotlinmvvpdemo.mvvp.presenter

import com.jjshouse.kotlinmvvpdemo.model.databean.StartPageBean
import com.jjshouse.kotlinmvvpdemo.model.httprequestbody.GetStartPageBody
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.SplashActivityContract
import org.cchao.http.HttpResponseModel
import org.cchao.http.HttpUtils
import org.cchao.kotlintemplate.expansion.bindToDestroy
import com.jjshouse.kotlinmvvpdemo.base.BasePresenterImpl
import com.jjshouse.kotlinmvvpdemo.base.BaseView
import javax.inject.Inject

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.mvvp.presenter
 * Created by xbzhang on 2020/1/7
 * Description:
 *
 */
class SplashActivityPresenter @Inject constructor(view: BaseView) :
    BasePresenterImpl<SplashActivityContract.View>(view), SplashActivityContract.Presenter {
    override fun getStartPage() {
        HttpUtils.getBaseData(GetStartPageBody(), StartPageBean::class.java,true).subscribe({
            when(it.code){
                HttpResponseModel.CODE_SUCCESS -> getPresenterView()?.onGetDataSuccess(it.data!!)
                else -> getPresenterView()?.onGetDataError(it.msg)
            }

        },{
            getPresenterView()?.onGetDataError(it.message!!)
        }).bindToDestroy(this)
    }
}