package com.yahier.androidtest.service;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by yahier on 17/2/10.
 * 内部有HandlerThread。这里属于子线程的.
 * 持有一个message队列,全部执行完成才会调用onDestoy和quit退出方法
 */

public class MyIntentService extends IntentService {
    final String tag = "MyIntentService";

    public MyIntentService() {
        super("yahier.MyIntentService");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(tag, "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(tag, "onDestroy");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.e(tag, "onHandleIntent");
        sleep5000();
    }

    void sleep5000() {
        Log.e(tag, "sleep之前 threadId:" + Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e(tag, "sleep之后");
    }
}
