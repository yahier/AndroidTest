package com.yahier.androidtest.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;

import com.yahier.androidtest.R;

import java.util.ArrayList;
import java.util.List;

public class TouchView extends View {
    final String tag = "TouchView";
    private Paint paint = null;
    List<Point> list;
    Bitmap bitmap;
    float left, top;
    Scroller mScroller;

    public TouchView(Context context) {
        super(context);
        paint = new Paint();
        list = new ArrayList<Point>();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        mScroller = new Scroller(context);
    }

    public TouchView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // this(context);
        paint = new Paint();
        list = new ArrayList<Point>();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
        mScroller = new Scroller(context);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            left = event.getX();
            top = event.getY();
            //invalidate((int) left, (int) top, 100, 100);
            invalidate();
            System.out.println("down");
            mScroller.startScroll(0, 0, 400, 400);
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.e(tag, "left:" + left);
        canvas.drawBitmap(bitmap, left, top, paint);
        canvas.save();
        System.out.println("draw.");
    }

    @Override
    public void computeScroll() {
        Log.e(tag, "computeScroll");
        if (mScroller.computeScrollOffset()) {
            scrollTo(mScroller.getCurrX(), mScroller.getCurrY());
            postInvalidate();
        }
    }
}
