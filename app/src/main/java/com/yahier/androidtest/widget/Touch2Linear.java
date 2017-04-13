package com.yahier.androidtest.widget;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.yahier.androidtest.R;

public class Touch2Linear extends LinearLayout {
    static final String TAG = "Touch2Linear";
    private Paint paint = null;
    //
    Bitmap bitmap;
    float left, top;

    public Touch2Linear(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.w);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG, "dispatchTouchEvent");
        return super.dispatchTouchEvent(ev);
        //return false;
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
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent");
        //return super.onTouchEvent(event);
        return true;
    }


}
