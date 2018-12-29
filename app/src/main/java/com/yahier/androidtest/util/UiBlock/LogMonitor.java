package com.yahier.androidtest.util.UiBlock;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yahier on 12/29/18.
 */

public class LogMonitor {

    private static LogMonitor sInstance = new LogMonitor();
    private HandlerThread mLogThread = new HandlerThread("log");
    private Handler mIoHandler;
    private static final long TIME_BLOCK = 400L;//监听的时间阀值

    private LogMonitor() {
        mLogThread.start();
        mIoHandler = new Handler(mLogThread.getLooper());
    }

    private static Runnable mLogRunnable = new Runnable() {
        @Override
        public void run() {
            StringBuilder sb = new StringBuilder();
            StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
            for (StackTraceElement s : stackTrace) {
                sb.append(s.toString() + "\n");
            }
            Log.e("TAG", sb.toString());
        }
    };

    public static LogMonitor getInstance() {
        return sInstance;
    }


    public boolean isMonitor() {
        //需要反射来调用此方法
        // boolean hasCallback = mIoHandler.hasCallbacks(mLogRunnable);
        Class<Handler> mClass = (Class<Handler>) mIoHandler.getClass();
        try {
            Method method = mClass.getMethod("hasCallbacks", Runnable.class);
            try {
                boolean hasCallback = (boolean) method.invoke(mIoHandler, mLogRunnable);
                //Log.d("isMonitor", "hasCallback:" + hasCallback);
                return hasCallback;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return false;
    }

    public void startMonitor() {
        mIoHandler.postDelayed(mLogRunnable, TIME_BLOCK);
    }

    public void removeMonitor() {
        mIoHandler.removeCallbacks(mLogRunnable);
    }


}
