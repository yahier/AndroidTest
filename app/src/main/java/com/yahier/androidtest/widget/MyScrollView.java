package com.yahier.androidtest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Scroller;

/**
 * 主要是试验 scroller
 */
public class MyScrollView extends ViewGroup {

    private int mScreeHeight;//屏幕高度
    private Scroller mScroller;
    private int mLastY;
    private int mStart;
    private int mEnd;
    private Context context;


    public MyScrollView(Context context) {
        super(context);
        initView(context);
    }

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyScrollView(Context context, AttributeSet attrs,
                        int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }


    private void initView(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        //DisplayMetrics 类提供了一种关于显示的通用信息，如显示大小，分辨率和字体。
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        mScreeHeight = dm.heightPixels;//高度（像素）
        mScroller = new Scroller(context);
    }


    //继承ViewGroup必须要实现的方法
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();//获取子view的个数
        //设置ViewGroup的高度

        //todo 这里是比较聪明的做法，直接转到父类。不会出现 cast 异常了
        MarginLayoutParams mlp = (MarginLayoutParams) getLayoutParams();
        mlp.height = mScreeHeight * childCount;
        setLayoutParams(mlp);
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != View.GONE) {
                //参数为相对父容器的左上右下位置,第三个参数必须为r
                Log.e("onLayout", "mScreeHeight is " + mScreeHeight + " r:" + r);
                child.layout(0, i * mScreeHeight, r, (i + 1) * mScreeHeight);
            }
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
        }

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        setMeasuredDimension(widthSize, mScreeHeight * getChildCount());
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int y = (int) event.getY();//相对于view的y值，getRawY()是相对屏幕
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLastY = y;//上一次的y值
                mStart = getScrollY();//记录触摸起点
                break;
            case MotionEvent.ACTION_MOVE:
                if (!mScroller.isFinished()) {
                    mScroller.abortAnimation();//放弃移到最终位置
                }
                int dy = mLastY - y;//偏移距离
                //如果滑动距离小于0或大于屏幕高度，不偏移
                if (getScrollY() < 0) {
                    dy = 0;
                }
                if (getScrollY() > getHeight() - mScreeHeight) {
                    dy = 0;
                }
                scrollBy(0, dy);//移动
                mLastY = y;
                break;
            case MotionEvent.ACTION_UP:
                int dScrollY = checkAlignment();//整体移动的距离
                if (dScrollY > 0) {
                    if (dScrollY < mScreeHeight / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0, mScreeHeight - dScrollY);
                    }
                } else {
                    if (-dScrollY < mScreeHeight / 3) {
                        mScroller.startScroll(0, getScrollY(), 0, -dScrollY);
                    } else {
                        mScroller.startScroll(0, getScrollY(), 0, -mScreeHeight - dScrollY);
                    }
                }
                break;
        }
        postInvalidate();
        return true;
    }


    /**
     * 从下往上滚动时  end:1108 mStart:0
     */
    private int checkAlignment() {
        mEnd = getScrollY();//记录触摸终点
        Log.e("checkAlignment", "end:" + mEnd + " mStart:" + mStart);
        boolean isUp = (mEnd - mStart) > 0;
        int lastPrev = mEnd % mScreeHeight;
        int lastNext = mScreeHeight - lastPrev;
        if (isUp) {
            return lastPrev;//向上
        } else
            return -lastNext;
    }


    @Override
    public void computeScroll() {
        super.computeScroll();
        if (mScroller.computeScrollOffset()) {//返回true，表示还未移动完
            scrollTo(0, mScroller.getCurrY());//移到当前位置
            postInvalidate();
            //invalidate()是用来刷新View的，必须是在UI线程中进行工作。
            //postInvalidate()可以在非UI线程调用
        }
    }
}
