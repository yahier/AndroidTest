package com.yahier.androidtest.util

import android.content.Context
import android.graphics.Point
import android.view.WindowManager

/**
 * Created by Administrator on 2017/6/6 0006.
 */

object DisplayUtil {
    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     */
    fun px2dip(context: Context, pxValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     */
    fun dip2px(context: Context, dipValue: Float): Int {
        val scale = context.resources.displayMetrics.density
        return (dipValue * scale + 0.5f).toInt()
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     */
    fun px2sp(context: Context, pxValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (pxValue / fontScale + 0.5f).toInt()
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     */
    fun sp2px(context: Context, spValue: Float): Int {
        val fontScale = context.resources.displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }

    /**
     * 获取屏幕分辨率
     */
    fun getScreenDisplay(context: Context): Point {
        val windowManager = context
                .getSystemService(Context.WINDOW_SERVICE) as WindowManager
        //val width = windowManager.defaultDisplay.width// 手机屏幕的宽度
        //val height = windowManager.defaultDisplay.height// 手机屏幕的高度

        val point = Point()
        windowManager.defaultDisplay.getSize(point)

        return point
    }
}
