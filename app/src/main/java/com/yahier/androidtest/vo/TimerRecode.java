package com.yahier.androidtest.vo;

import android.content.Context;
import android.content.SharedPreferences;

import com.yahier.androidtest.common.MyApp;

/**
 * Created by lenovo on 2017/7/16.
 * 记录时间，需要倒计时的时候使用
 */

public class TimerRecode {
    private static final String fileName = "yahier";

    public static void save(String className, long timeLeft) {
        SharedPreferences.Editor editor = MyApp.getContext().getSharedPreferences(fileName, Context.MODE_PRIVATE).edit();
        long time = System.currentTimeMillis();
        editor.putString(className, timeLeft + "#" + time).apply();
    }

    public static long getTimeLeft(String className) {
        SharedPreferences sp = MyApp.getContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
        String values = sp.getString(className, "");
        if (values.equals("")) return 0;
        long timeLeft = Long.valueOf(values.split("#")[0]);
        long oldTimeMillions = Long.valueOf(values.split("#")[1]);
        timeLeft = timeLeft - (System.currentTimeMillis() - oldTimeMillions);
        if (timeLeft < 0) timeLeft = 0;
        return timeLeft;
    }

    public static void clear() {
        MyApp.getContext().getSharedPreferences(fileName, Context.MODE_PRIVATE).edit().clear().apply();
    }

}
