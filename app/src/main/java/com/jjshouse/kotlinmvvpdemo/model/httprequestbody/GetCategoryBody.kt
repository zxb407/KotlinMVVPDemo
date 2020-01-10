package com.jjshouse.kotlinmvvpdemo.model.httprequestbody

import org.cchao.http.HttpRequestBody
import org.cchao.http.RetrofitUtils

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.model.httprequestbody
 * Created by xbzhang on 2020/1/7
 * Description:
 *
 */
class GetCategoryBody(var name: String) : HttpRequestBody() {
    override fun getMethod(): Method {
        return Method.GET
    }

    override fun getUrl(): String {
        return RetrofitUtils.BASE_URL + "api/v1/c1/common/siderBar/2/"
    }
}