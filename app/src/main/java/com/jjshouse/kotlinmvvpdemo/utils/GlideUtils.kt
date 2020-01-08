package com.jjshouse.kotlinmvvpdemo.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.request.RequestOptions
import com.jjshouse.kotlinmvvpdemo.GlideApp

/**
 * PackageName: com.jjshouse.kotlinmvvpdemo.utils
 * Created by xbzhang on 2020/1/6
 * Description:
 */
object GlideUtils {
    fun setImageUrl(view: ImageView, url: String) {
        GlideApp.with(view.context).load(url).into(view)
    }

    fun setImageUrlWithFixedWidth(view: ImageView, url: String, width: Int) {
        GlideApp.with(view.context).load(url)
    }

    fun setImageUrlWithFixedHeight(view: ImageView, url: String, height: Int) {

    }

    fun setImageUrlWithOptions(view: ImageView, url: String, options: RequestOptions) {

    }

}
