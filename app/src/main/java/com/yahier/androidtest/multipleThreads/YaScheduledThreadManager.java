package com.yahier.androidtest.multipleThreads;

import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * Created by yahier on 2018/7/19.
 * schedule线程池
 */

public class YaScheduledThreadManager {
    private static final String TAG = "YaThreadManager";
    static HashMap<String, ScheduledFuture> hashMap = new HashMap<>();

    private static YaScheduledThreadManager instance;

    private static ScheduledExecutorService service;

    static {
        hashMap.clear();
        service = Executors.newScheduledThreadPool(4);
    }

    static YaScheduledThreadManager getInstance() {
        synchronized (YaScheduledThreadManager.class) {
            if (instance == null) {
                instance = new YaScheduledThreadManager();
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


    public void startCycle(String tag, Runnable runnable, long interval) {
        ScheduledFuture future = service.scheduleAtFixedRate(runnable, 0, interval, TimeUnit.SECONDS);
        hashMap.put(tag, future);
    }

    public void cancel(String tag) {
        ScheduledFuture future = hashMap.get(tag);
        if (future != null)
            future.cancel(true);
    }

    /**
     * 怎么样停止某一个任务 很为难啊
     */
    public void stop(Runnable runnable) {

    }


}
