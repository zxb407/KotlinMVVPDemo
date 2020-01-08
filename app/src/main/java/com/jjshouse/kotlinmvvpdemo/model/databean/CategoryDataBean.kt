package com.jjshouse.kotlinmvvpdemo.model.databean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * PackageName: com.veryvoga.vv.bean
 * Created by xbzhang on 2019/1/30
 * Description:
 *
 */
data class CategoryDataBean(
        val banner: String,
        val cat_id: String,
        val name: String,
        val nativeConfig: NativeConfig,
        val subnav: List<SubnavBean>,
        val url: String
)

@Parcelize
data class NativeConfig(
        val filter: String,
        var nativeUrl: String,
        val type: Int,
        var gid: String? = null
) : Parcelable

data class SubnavBean(
        val children: List<Children>,
        val name: String,
        val nativeConfig: NativeConfig,
        val url: String
)

data class Children(
        val img: String,
        val name: String,
        val nativeConfig: NativeConfig,
        val url: String
)