package com.jjshouse.kotlinmvvpdemo.mvvp.presenter

import com.jjshouse.kotlinmvvpdemo.model.databean.CategoryBean
import com.jjshouse.kotlinmvvpdemo.model.httprequestbody.GetCategoryBody
import com.jjshouse.kotlinmvvpdemo.mvvp.contract.CategoryFragmentContract
import org.cchao.http.HttpUtils
import org.cchao.kotlintemplate.expansion.bindToDestroy
import org.cchao.kotlintemplate.ui.base.BasePresenterImpl
import org.cchao.kotlintemplate.ui.base.BaseView
import javax.inject.Inject


/**
 * Created by wing on 16-11-25.
 */
class CategoryFragmentPresenter @Inject constructor(view: BaseView) :
    BasePresenterImpl<CategoryFragmentContract.View>(view)
    , CategoryFragmentContract.Presenter {
    override fun getCategoryInfo() {
        HttpUtils.getBaseData(GetCategoryBody("category"), CategoryBean::class.java,true).subscribe({
            if (it.code == 0) {
                it.data?.let { t ->
                    getPresenterView()?.onCategorySuccess(t.data)
                }
            }
        }, {
            getPresenterView()?.onCategoryError(it.message!!)
        }).bindToDestroy(this)
    }
}
