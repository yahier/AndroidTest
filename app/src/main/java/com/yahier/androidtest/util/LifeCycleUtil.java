package com.yahier.androidtest.util;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

/**
 * <pre>
 * ======================================================
 * intention:  判断app是否运行于前台
 *
 * @author: cj
 * @date: 2017-09-13
 * ======================================================
 * </pre>
 */

public class LifeCycleUtil implements Application.ActivityLifecycleCallbacks {
    final String TAG = "LifeCycleUtil";

    private static LifeCycleUtil lifeCycleUtil;

    private LifeCycleUtil() {

    }

    public static LifeCycleUtil getInstant() {
        if (null == lifeCycleUtil) {
            lifeCycleUtil = new LifeCycleUtil();
        }
        return lifeCycleUtil;
    }


    //记录当前页面的路径。有时候在大型应用中 很有用。
    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Log.e(TAG, "onCreate:" + activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityStarted(Activity activity) {
        Log.e(TAG, "onActivityStarted:" + activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        Log.e(TAG, "onActivityResumed:" + activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityPaused(Activity activity) {
        Log.e(TAG, "onActivityPaused:" + activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityStopped(Activity activity) {
        Log.e(TAG, "onActivityStopped:" + activity.getClass().getSimpleName());
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Log.e(TAG, "onActivitySaveInstanceState:" + activity.getClass().getSimpleName());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        Log.e(TAG, "onActivityDestroyed:" + activity.getClass().getSimpleName());

    }

}
