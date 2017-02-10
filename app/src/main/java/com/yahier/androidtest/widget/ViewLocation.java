package com.yahier.androidtest.widget;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yahier.androidtest.R;

/**
 * Created by Administrator on 2017/2/4.
 */

public class ViewLocation extends LinearLayout {

    public ViewLocation(Context context) {
        super(context);
        initViews();
    }

    public ViewLocation(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews();
    }


    void initViews() {
        TextView textView = new TextView(getContext());
        textView.setText("祝你前程似锦哈");
        textView.setBackgroundResource(R.color.blue);
        //layout方法的调用 一般在viewgroup方法中的onLayout方法中调用子类的。也可以查看开发鉴赏一书的相关内容
        //no work
        //textView.layout(200, 200, 900, 900);
        //textView.forceLayout();
        //textView.requestLayout();


        //works
        textView.setWidth(1000);
        textView.setHeight(400);

        Layout layout = textView.getLayout();
        addView(textView);

    }


}
