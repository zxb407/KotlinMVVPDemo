package com.core.frame.utils.glideutils.options

import android.graphics.drawable.Drawable
import com.bumptech.glide.RequestBuilder

data class GlideOptions(
    var doAnimate: Boolean = false,
    var replaceImage: Int = 0,
    var errImage: Int = replaceImage,
    var thumbnail: Boolean = false,
    var thumb_level: Float = 0.1f,
    var requestBuilder: RequestBuilder<Drawable>? = null
)
