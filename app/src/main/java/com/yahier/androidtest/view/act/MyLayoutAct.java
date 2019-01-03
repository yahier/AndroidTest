package com.yahier.androidtest.view.act;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/4/2.
 */

public class MyLayoutAct extends com.yahier.androidtest.BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
    }
}
