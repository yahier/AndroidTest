package com.yahier.androidtest.common;

import android.app.Application;
import android.util.Log;

import com.squareup.leakcanary.LeakCanary;
import com.yahier.androidtest.util.LifeCycleUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        Log.e(TAG, "onCreate");
        setJPush();
        app = this;
        LeakCanary.install(this);
        registerActivityLifecycleCallbacks(LifeCycleUtil.getInstant());
        ExecutorService service = Executors.newCachedThreadPool();
    }

    public static MyApp getContext() {
        return app;
    }

    private void setJPush() {
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
        Set<String> set = new HashSet<>();
        set.add("tag1");
        JPushInterface.setTags(this, set, (i, s, set1) -> {

        });
        Log.e(TAG, "极光初始化完成");
    }
}
