package com.jjshouse.kotlinmvvpdemo.utils

import java.math.BigDecimal

/**
 * PackageName: com.veryvoga.vv.utils
 * Created by xbzhang on 2019/4/29
 * Description:
 *
 */
object UtilsBigDecimal {

    // 需要精确至小数点后几位
    const val DECIMAL_POINT_NUMBER: Int = 2

    // 加法运算
    @JvmStatic
    fun add(d1: Double, d2: Double): Double = BigDecimal(d1).add(BigDecimal(d2)).setScale(DECIMAL_POINT_NUMBER, BigDecimal.ROUND_DOWN).toDouble()

    // 减法运算
    @JvmStatic
    fun sub(d1: Double, d2: Double): Double = BigDecimal(d1).subtract(BigDecimal(d2)).setScale(DECIMAL_POINT_NUMBER, BigDecimal.ROUND_DOWN).toDouble()

    // 乘法运算
    @JvmStatic
    fun mul(d1: Double, d2: Double, decimalPoint: Int): Double = BigDecimal(d1).multiply(BigDecimal(d2)).setScale(decimalPoint, BigDecimal.ROUND_DOWN).toDouble()

    // 除法运算
    @JvmStatic
    fun div(d1: Double, d2: Double): Double = BigDecimal(d1).divide(BigDecimal(d2), DECIMAL_POINT_NUMBER,BigDecimal.ROUND_DOWN).toDouble()
}