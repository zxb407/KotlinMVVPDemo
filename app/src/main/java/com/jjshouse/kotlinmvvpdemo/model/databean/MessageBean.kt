package com.jjshouse.kotlinmvvpdemo.model.databean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MessageListBean(
        var list: List<MessageBean>
) : Parcelable

/**
 * 推送的消息
 */
data class PushMessageBean(
        var direct_info: String,
        var img: String
)

@Parcelize
data class MessageBean(
        var id: String,
        var content: String,
        var direct_info: DirectInfo?,
        var img: List<Img>,
        var is_read: Int,
        var message_type: Int,
        var status: Int,
        var title: String,
        var created_time: Long
) : Parcelable

@Parcelize
data class Img(
        var url: String,
        var type: String
) : Parcelable

@Parcelize
data class DirectInfo(
        var params: Param,
        var path: String,
        var type: Int,
        //大于1000表示运营推送
        var message_type: Int
) : Parcelable

@Parcelize
data class Param(
        var order_sn: String?,
        //是否拆单，0未拆单；1拆单
        var is_disassemble: Int,
        var goods_id: String?
) : Parcelable