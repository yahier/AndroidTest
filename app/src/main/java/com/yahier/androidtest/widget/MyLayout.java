package com.yahier.androidtest.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
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


    /**
     * wrap_content对应at_most.另外的match_parent和具体值都是EXACTLY
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    int paddingLeft;

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
//        //加上以下就是为了适配wrap_content
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        paddingLeft = getPaddingLeft();


        //开始处理wrap_content,如果一个子元素都没有，就设置为0
        if (getChildCount() == 0) {
            setMeasuredDimension(0, 0);
        } else if (widthMode == MeasureSpec.AT_MOST && heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup，宽，高都是wrap_content，根据我们的需求，宽度是子控件的宽度，高度则是所有子控件的总和
            View childOne = getChildAt(0);
            int childWidth = childOne.getMeasuredWidth();
            int childHeight = childOne.getMeasuredHeight();
            setMeasuredDimension(childWidth, childHeight * getChildCount());
        } else if (widthMode == MeasureSpec.AT_MOST) {
            //ViewGroup的宽度为wrap_content,则高度不需要管，宽度还是自控件的宽度
            View childOne = getChildAt(0);
            int childWidth = childOne.getMeasuredWidth();
            setMeasuredDimension(childWidth, heightSize);
        } else if (heightMode == MeasureSpec.AT_MOST) {
            //ViewGroup的高度为wrap_content,则宽度不需要管，高度为子View的高度和
            View childOne = getChildAt(0);
            int childHeight = childOne.getMeasuredHeight();
            Log.e("onMeasure", "childHeight:" + childHeight);
            setMeasuredDimension(paddingLeft + widthSize, childHeight * getChildCount());
        }
    }


    //参数是距离parent的位置
    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.e(TAG, "onLayout:" + changed + "-" + l + "-" + t + "-" + r + "-" + b);//显示的是屏幕数据。
        int childCount = getChildCount();
        int heightSum = 0;

        l = paddingLeft;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            //计算margin距离
            MarginLayoutParams params = (MarginLayoutParams) child.getLayoutParams();
            int marginTop = params.topMargin;
            Log.e(TAG, "width2:" + child.getWidth());
            Log.e(TAG, "width3:" + child.getMeasuredWidth());

            //垂直排放
            child.layout(l, marginTop + t + heightSum, l + child.getMeasuredWidth(), marginTop + t + child.getMeasuredHeight() + heightSum);
            heightSum = heightSum + child.getMeasuredHeight();

        }

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Log.e(TAG, "dispatchDraw");
        //Paint paint = new Paint();
        //paint.setColor(Color.BLUE);
        //canvas.drawLine(0,0,100,100,paint);
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
