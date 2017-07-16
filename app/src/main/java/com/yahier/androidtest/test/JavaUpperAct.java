package com.yahier.androidtest.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/4/29.
 * lambda涉及到所有的接口么，怎么自动提示呢
 */

public class JavaUpperAct extends Activity {
    static final String TAG = "JavaUpperAct";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        findViewById(R.id.button).setOnClickListener(v -> test1());

    }


    void test1() {
        getWindow().getDecorView().post(() -> onDelayLoad());
        Log.e(TAG, "test1");

    }

    /**
     * 延时加载
     */
    private void onDelayLoad() {
        Log.e(TAG, "onDelayLoad");
    }
}
