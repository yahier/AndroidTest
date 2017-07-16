package com.yahier.androidtest;

import android.app.Application;
import android.util.Log;

import com.yahier.androidtest.common.MyApp;

/**
 * Created by yahier on 17/4/28.
 */

public class App extends MyApp {
    final String TAG = "App";
    private static App application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
        Log.e(TAG, "onCreate");
    }

    public App() {
        application = this;
    }

    public static App getApplication() {
        return application;
    }

}
