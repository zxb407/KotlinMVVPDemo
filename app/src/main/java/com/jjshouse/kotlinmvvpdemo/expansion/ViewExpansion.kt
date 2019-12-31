package org.cchao.kotlintemplate.expansion

import android.annotation.SuppressLint
import android.view.Gravity
import android.view.View
import com.core.frame.utils.NetworkUtils
import com.core.frame.utils.ToastUtils
import com.jakewharton.rxbinding2.view.RxView
import com.jjshouse.kotlinmvvpdemo.R
import java.util.concurrent.TimeUnit

/**
 * @author cchen6
 * @Date on 2019/7/1
 * @Description
 */
fun View.click(onClickListener: View.OnClickListener) {
    clickWithTrigger(onClickListener, 300L)
}

@SuppressLint("CheckResult")
fun View.clickWithTrigger(onClickListener: View.OnClickListener, triggerTime: Long) {
    RxView.clicks(this).throttleFirst(triggerTime, TimeUnit.MILLISECONDS).subscribe {
        if (!NetworkUtils.isConnected()) {
            ToastUtils.showCustomShort(R.layout.layout_net_error_toast,Gravity.CENTER)
            return@subscribe
        }
        onClickListener.onClick(this)
    }
}