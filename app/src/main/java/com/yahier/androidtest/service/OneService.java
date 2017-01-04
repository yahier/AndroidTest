package com.yahier.androidtest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by yahier on 17/1/4.
 */

public class OneService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("OneService", "onCreate");
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("OneService", "onStart");
        test();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    void test() {
        Toast.makeText(this, "test方法被调用", Toast.LENGTH_SHORT).show();
    }


    public IBinder onBind(Intent intent) {
        return mBinder;
    }


    private final IBinder mBinder = new LocalBinder();
    public class LocalBinder extends Binder {
        OneService getService() {
            return OneService.this;
        }
    }


}
