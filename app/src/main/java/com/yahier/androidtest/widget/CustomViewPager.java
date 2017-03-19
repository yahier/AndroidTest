package com.yahier.androidtest.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;

import com.yahier.androidtest.R;


/**
 * Created by zhy on 16/6/23.
 * very good! by yahier
 */
public class CustomViewPager extends ViewPager {
    final String TAG = "CustomViewPager";
    private Bitmap mBg = BitmapFactory.decodeResource(getResources(), R.drawable.bg_home);

    public CustomViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private static final int INVALID_POS = -1;
    private int mFirstPos = INVALID_POS;

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (mFirstPos == INVALID_POS) {
            mFirstPos = getCurrentItem();
        }

        //宽度是720
        //Log.e(TAG, "dispatchDraw width:" + getWidth());
        //Log.e(TAG, "dispatchDraw getScrollX:" + getScrollX());

        if (this.mBg != null) {
            int width = mBg.getWidth();
            int height = mBg.getHeight();

            int count = getAdapter().getCount();


            int x = getScrollX() + mFirstPos * getWidth();

            //每个Item需要显示图片的宽度
            final float widthForItem = width * 1.0f / count;

            //控件每移动一个像素，图片应该移动的像素值
            float widthForPerPx = widthForItem * 1.0f / getWidth();

            //第一个Rect 代表要绘制的bitmap 区域，第二个 Rect 代表的是要将bitmap 绘制在屏幕的什么地方

            int bitmapLeft = (int) (x * widthForPerPx);
            Rect src = new Rect(bitmapLeft, 0, (int) (bitmapLeft + widthForItem), height);

            int drawAreaLeft = getScrollX();
            Rect dest = new Rect(drawAreaLeft, 0, drawAreaLeft + getWidth(), getHeight());

            canvas.drawBitmap(mBg, src, dest, null);

        }
        super.dispatchDraw(canvas);
    }

}
