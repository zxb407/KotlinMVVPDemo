package org.cchao.http

import androidx.annotation.Keep

/**
 * @author cchen6
 * @Date on 2019/8/2
 * @Description
 */
@Keep
class HttpResponseModel<T> {

    var code: Int = 0

    var msg: String = ""

    var data: T? = null

    val isSuccess: Boolean
        get() = code == CODE_SUCCESS

    companion object {

        val CODE_ERROR = -1
        val CODE_SUCCESS = 0
    }
}
