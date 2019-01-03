package com.yahier.androidtest.view.act;

import android.os.Bundle;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/4/12
 * 通过设置style.的windowBackground来消灭启动瞬间的白屏。
 */

public class DrawableStyleAct extends com.yahier.androidtest.BaseActivity {
    final String TAG = "DrawableStyleAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_style);

    }


}
