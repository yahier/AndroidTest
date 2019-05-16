package com.yahier.androidtest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by yahier on 17/1/4.
 */

public class OneService extends Service {
    final String TAG = "OneService";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate");
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand");
        return START_STICKY;
    }


    @Override
    public void onRebind(Intent intent) {
        Log.e(TAG, "onRebind");
        super.onRebind(intent);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind");
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    @Override
    public boolean stopService(Intent name) {
        Log.e(TAG, "stopService");
        return super.stopService(name);
    }

    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind");
        return mBinder;
    }

    void test() {
        Toast.makeText(this, "test方法被调用", Toast.LENGTH_SHORT).show();
    }

    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        OneService getService() {
            return OneService.this;
        }
    }


}
