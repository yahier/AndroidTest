package com.yahier.androidtest.common;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by yahier on 17/1/27.
 */

public class MyApp extends Application {
    static MyApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        LeakCanary.install(this);
    }

    public static MyApp getContext() {
        return app;
    }
}
