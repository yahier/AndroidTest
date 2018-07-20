package com.yahier.androidtest.multipleThreads;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created by yahier on 2018/7/19.
 */

public class YaThreadManager {
    private static final String TAG = "YaThreadManager";


    private static YaThreadManager instance;

    private static ThreadPoolExecutor service;
    private static AsyncTask asyncTask;

    static {
        asyncTask = new MyAsyncTask();
        service = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
    }

    static YaThreadManager getInstance() {
        synchronized (YaThreadManager.class) {
            if (instance == null) {
                instance = new YaThreadManager();
            }
        }
        return instance;
    }


    public void execute(Task task) {
        service.submit(task.runnable);
    }

    public void execute(Runnable runnable) {
        service.submit(runnable);
    }

    public Future<String> execute(Callable<String> call) {
        return service.submit(call);
    }


    /**
     * 后来，我明白了
     * 这个传参需要改进 (外部保留引用不是个好法子)
     */
    public void cancel(Runnable runnable) {
        service.remove(runnable);
    }

    static class MyAsyncTask extends AsyncTask {

        @Override
        protected Object doInBackground(Object[] objects) {
            Log.e(TAG, "doInBackground");
            SystemClock.sleep(4000);
            return null;
        }
    }

}
