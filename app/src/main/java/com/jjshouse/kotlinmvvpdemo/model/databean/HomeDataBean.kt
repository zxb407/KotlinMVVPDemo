package com.jjshouse.kotlinmvvpdemo.model.databean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * PackageName: com.veryvoga.vv.bean
 * Created by xbzhang on 2019/4/12
 * Description:
 *
 */
data class HomeDataBean(
        val activityLabel: ActivityLabel,
        var banners: MutableList<Banner>,
        val slogan: Slogan,
        val bestSellCats: List<CatBean>
)

@Parcelize
data class CatBean(
        val catId: Int,
        val catName: String
) : Parcelable

data class Slogan(
        val content: MutableList<Content>,
        val hasBanner: Boolean,
        val showTimer: Boolean,
        val styleConf: StyleConf
)

data class Content(
        val image: String,
        val text: String,
        val url: String,
        val nativeConfig: NativeConfig
)

data class StyleConf(
        val background: String,
        val height: Int,
        val textColor: String,
        val width: Int
)

data class Banner(
        val allText: String,
        val allUrl: String,
        val config: MutableList<Config>,
        val galleryConfig: MutableList<GalleryBean>,
        val title: String,
        val type: Int,
        val columnNum: Int,
        val nativeConfig: NativeConfig
)

data class GalleryBean(
        val favourite: Int,
        val galleryId: String,
        val img: String,
        val isFavourite: Boolean
)

data class Config(
        val height: Double,
        val image: String,
        val shopPrice: String,
        val showActivityLabel: Int,
        val url: String,
        val width: Double,
        val nativeConfig: NativeConfig,
        val goodsId: String,
        val goodsImg: String,
        val isRectangle: Int = 1
)

data class ActivityLabel(
        val height: Double,
        val image: String,
        val width: Double
)