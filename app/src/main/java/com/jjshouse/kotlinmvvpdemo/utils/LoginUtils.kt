package com.jjshouse.kotlinmvvpdemo.utils

import android.annotation.SuppressLint
import android.app.Activity

/**
 * PackageName: com.veryvoga.vv.base
 * Created by xbzhang on 2019/12/12
 * Description:
 */

@SuppressLint("StaticFieldLeak")
object LoginUtils {
    private var iLogin: ILogin? = null
    private var activity: Activity? = null

    fun isLogin() {
        //下面先判断到底有没有登录，一般都会在本地保存。
//        if (AppUtils.getLoginStatus()) {
//            iLogin?.onlogin()
//            clear()
//        } else {
//            activity?.startActivity(Intent(activity,LoginRegisterActivity::class.java))
//        }
    }

    /**
     * 登录页面销毁前必须调用此方法清除listener
     */
    private fun clear() {
        if (iLogin != null) {
            iLogin = null
        }
        if (activity != null) {
            activity = null
        }
    }

    fun setLoginListener(listener: ILogin, activity: Activity) {
        iLogin = listener
        LoginUtils.activity = activity
        isLogin()
    }

    interface ILogin {
        fun onlogin()
    }
}
