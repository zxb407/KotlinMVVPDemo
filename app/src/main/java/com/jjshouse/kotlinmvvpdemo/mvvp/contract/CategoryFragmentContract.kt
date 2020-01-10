package com.jjshouse.kotlinmvvpdemo.mvvp.contract

import com.jjshouse.kotlinmvvpdemo.model.databean.CategoryDataBean
import org.cchao.kotlintemplate.ui.base.BasePresenter
import org.cchao.kotlintemplate.ui.base.BaseView

/**
 * Contract for 商品目录
 * Created by wing on 16-11-25.
 */
interface CategoryFragmentContract{
    interface View :BaseView{
        /**商品目录数据获取成功时回调*/
        fun onCategorySuccess(data: List<CategoryDataBean>)
        /**商品目录数据获取失败时回调*/
        fun onCategoryError(msg:String)
    }

    interface Presenter :BasePresenter{
        /**获取商品目录数据*/
        fun getCategoryInfo()
    }

}