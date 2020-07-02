package com.core.frame.utils.glideutils.options

import android.content.res.Resources
import com.core.frame.R

import java.util.HashMap

object GlideOptionsFactory {
    private var mOptions: HashMap<Type, GlideOptions>? = null

    private fun init() {
        if (mOptions == null) {
            mOptions = HashMap()
            mOptions!![Type.DEFAULT] = GlideOptions(replaceImage= R.drawable.ic_black_placeholder, doAnimate = true)
            mOptions!![Type.LOGO] = GlideOptions(replaceImage = R.mipmap.pic_default, doAnimate = false)
            mOptions!![Type.THUMBNAIL] = GlideOptions(replaceImage = R.drawable.ic_black_placeholder, doAnimate = true,thumbnail = true,thumb_level = 0.1f)
        }
    }

    operator fun get(type: Type): GlideOptions? {
        init()
        if (mOptions!!.containsKey(type)) {
            return mOptions!![type]
        }

        throw IllegalArgumentException()
    }

    enum class Type private constructor(private val type: Int) {
        DEFAULT(1), LOGO(2),THUMBNAIL(3);

        override fun toString(): String {
            return "type:$type"
        }
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(dpValue: Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }
}
