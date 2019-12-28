package com.yahier.androidtest.view.act

import android.os.Bundle
import com.yahier.androidtest.BaseActivity
import kotlinx.android.synthetic.main.act_mix_img.*
import android.graphics.drawable.BitmapDrawable
import android.graphics.*
import android.graphics.Bitmap
import com.yahier.androidtest.R

/**
 * 绘制效果 参考 https://developer.android.google.cn/reference/android/graphics/PorterDuff.Mode?hl=en
 */
class MixImgAct : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_mix_img)
        title = "绘制圆形图片 与 图片融合"

        btnDrawShapeImg.setOnClickListener {
            val bitmap = getShapeBitmap()
            imgMixed.setImageBitmap(bitmap)
        }

        btnMix.setOnClickListener {
            val wukomng = BitmapFactory.decodeResource(resources, R.drawable.wukong)

            imgMixed.setImageBitmap(mixImg(wukomng))

        }
    }

    private fun getShapeBitmap(): Bitmap {
        val db = resources.getDrawable(R.drawable.wukong) as BitmapDrawable
        val bitmap = db.bitmap
        val output = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val paint = Paint(Color.GREEN)
        paint.isAntiAlias = true//设置抗锯齿效果  就是平滑效果
        val rect = Rect(0, 0, bitmap.width, bitmap.height)
        // 圆角矩形
        rect.run {
            val rectF = RectF(rect)
            val roundPx = 90f//设置圆角半径20
            canvas.drawRoundRect(rectF, roundPx, roundPx, paint)
        }
        //画圆
        canvas.run {
            canvas.drawCircle(bitmap.width / 2.toFloat(), bitmap.height / 2.toFloat(), bitmap.width.toFloat() / 2, paint)
        }
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)//模式 取图片1的重叠
        canvas.drawBitmap(bitmap, rect, rect, paint)
        return output
    }


    /**
     * 取两张突破的不同绘制的效果 连续调用两次drawBitmap也是可以的 参考文档 https://developer.android.google.cn/reference/android/graphics/PorterDuff.Mode?hl=en
     */
    private fun mixImg(bitmapSecond: Bitmap): Bitmap {
        val db = resources.getDrawable(R.drawable.haifei) as BitmapDrawable
        val bitmap = db.bitmap
        val output = Bitmap.createBitmap(bitmap.width, bitmap.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(output)
        val paint = Paint(Color.GREEN)
        paint.isAntiAlias = true//设置抗锯齿效果  就是平滑效果
        val rect = Rect(0, 0, bitmap.width, bitmap.height)
        //绘制第二张图片
        rect.run {
            val mBitmap = getNewBitmap(bitmapSecond, bitmapSecond.width / 3, bitmapSecond.height / 3)
            val paintSecond = Paint(Color.GREEN)
            paintSecond.alpha = 50
            paintSecond.isAntiAlias = true//设置抗锯齿效果  就是平滑效果
            canvas.drawBitmap(mBitmap, 0f, 0f, paintSecond)
        }
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OVER)
        canvas.drawBitmap(bitmap, rect, rect, paint)
        return output
    }

    fun getNewBitmap(bitmap: Bitmap, newWidth: Int, newHeight: Int): Bitmap {
        // 获得图片的宽高.
        val width = bitmap.width
        val height = bitmap.height
        // 计算缩放比例.
        val scaleWidth = newWidth.toFloat() / width
        val scaleHeight = newHeight.toFloat() / height
        // 取得想要缩放的matrix参数.
        val matrix = Matrix()
        matrix.postScale(scaleWidth, scaleHeight)
        // 得到新的图片.
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true)
    }

}