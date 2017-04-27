package com.yahier.androidtest.common;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by yahier on 17/1/27.
 */

public class MyApp extends Application {
    final static String TAG = "MyApp";
    static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        Log.e(TAG, "onCreate");
        app = this;
        LeakCanary.install(this);
    }

    public static MyApp getContext() {
        return app;
    }
}
