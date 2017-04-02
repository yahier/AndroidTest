package com.yahier.androidtest.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by yahier on 17/4/2.
 * 1)getWidth必须layout之后才有值。getMeasuredWidth必须测量值才有值。
 */

public class MyLayout extends ViewGroup {
    final String TAG = "MyLayout";

    public MyLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }


    //参数是距离parent的位置
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e(TAG, "onLayout:" + changed + "-" + l + "-" + t + "-" + r + "-" + b);//显示的是屏幕数据。
        int childCount = getChildCount();
        int heightSum = 0;

        l = 0;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            //计算margin距离
            MarginLayoutParams params = (MarginLayoutParams) child.getLayoutParams();
            int marginTop = params.topMargin;
            Log.e(TAG, "width2:" + child.getWidth());
            Log.e(TAG, "width3:" + child.getMeasuredWidth());


            //尝试重叠摆放
            child.layout(l, marginTop + t + heightSum, l + child.getMeasuredWidth(), marginTop + t + child.getMeasuredHeight() + heightSum);
            heightSum = child.getMeasuredHeight();


        }

    }


    //必须重写。才到转换成功
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

}
