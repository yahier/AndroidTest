package com.yahier.androidtest.view.act;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/4/2.
 */

public class MyLayoutAct extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_layout);
    }
}
