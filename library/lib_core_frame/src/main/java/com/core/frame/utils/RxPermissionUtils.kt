package com.core.frame.utils

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import androidx.fragment.app.FragmentActivity
import com.tbruyelle.rxpermissions2.RxPermissions

/**
 * PackageName: com.core.frame.utils
 * Created by xbzhang on 2020/1/10
 * Description:
 *
 */
object RxPermissionUtils {

    const val PERMISSION_REQUEST_CODE = 0b1000001

    @SuppressLint("CheckResult")
    fun requestPermissions(activity: FragmentActivity, permissions:Array<String>, isNecessary:Boolean, listener:OnGrantedListener?){
        RxPermissions(activity)
            .requestEachCombined(*permissions)
            .subscribe {permission ->
                if (isNecessary){
                    when {
                        permission.granted ->
                            listener?.onGranted()
                        permission.shouldShowRequestPermissionRationale -> showTip(activity,2,permissions,listener)
                        else ->
                            showTip(activity,1,permissions,listener)
                    }
                }else{
                    listener?.onGranted()
                }
            }
    }

    private fun showTip(activity:FragmentActivity,type: Int,permissions:Array<String>,listener:OnGrantedListener?) {
        val builder = AlertDialog.Builder(activity)
        builder.setTitle("permission")
            .setMessage("点击允许才可以使用我们的app哦")
            .setPositiveButton("去允许") { dialog, id ->
                when (type) {
                    1 -> {
                        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                        val uri = Uri.fromParts("package", activity.packageName , null)
                        intent.data = uri
                        activity.startActivityForResult(intent, PERMISSION_REQUEST_CODE)
                    }
                    2 -> {
                        requestPermissions(activity,permissions,true,listener)
                    }
                }
            }
        var mDialog = builder.create()
        mDialog?.setCanceledOnTouchOutside(false)
        mDialog?.show()
    }
}

interface OnGrantedListener{
    fun onGranted()
}