package com.yahier.androidtest.view.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/4/13.
 * 测试事件分发。拦截
 */

public class MotionEventAct extends com.yahier.androidtest.BaseActivity implements View.OnClickListener {
    static final String TAG = "act";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.motion_event_act);
        findViewById(R.id.lin).setOnClickListener(this);
        findViewById(R.id.btn1).setOnClickListener(this);

        findViewById(R.id.lin).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.e(TAG, "lin onTouch");
                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lin:
                Log.e(TAG, "linClick");
                break;
            case R.id.btn1:
                Log.e(TAG, "btn1Click");
                break;
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }


    //点击的view没有操作onTouch时，事件会传递到此。
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG, "onTouchEvent");
        //return super.onTouchEvent(event);
        return false;
    }

}
