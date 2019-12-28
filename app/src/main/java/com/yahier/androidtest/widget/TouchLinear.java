package com.yahier.androidtest.widget;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.yahier.androidtest.R;

public class TouchLinear extends LinearLayout {
    static final String TAG = "TouchLinear";
    private Paint paint = null;
    //
    Bitmap bitmap;
    float left, top;

    public TouchLinear(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.w);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        //return super.dispatchTouchEvent(ev);
        return false;
    }

    /**
     * 不明白这个返回值对操作的影响
     *
     * @param ev
     * @return
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG, "onInterceptTouchEvent");
        //return super.onInterceptTouchEvent(ev);
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent");
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            left = event.getX();
            top = event.getY();
            invalidate();
            return true;
        } else if (event.getAction() == MotionEvent.ACTION_MOVE) {

            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, left, top, paint);
        //canvas.save(Canvas.ALL_SAVE_FLAG);
        canvas.save();
    }
}
