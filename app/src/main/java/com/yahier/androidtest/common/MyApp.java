package com.yahier.androidtest.common;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by yahier on 17/1/27.
 */

public class MyApp extends Application {
    final static String TAG = "MyApp";
    static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
        app = this;
        LeakCanary.install(this);
    }

    public static MyApp getContext() {
        return app;
    }
}
