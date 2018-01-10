package com.yahier.androidtest;

import android.app.Application;
import android.util.Log;

import com.alibaba.android.arouter.launcher.ARouter;
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
        if (true) {           // 这两行必须写在init之前，否则这些配置在init过程中将无效
            ARouter.openLog();     // 打印日志
            ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        }
        ARouter.init(this);
        Log.e(TAG, "onCreate");
    }

    public App() {
        application = this;
    }

    public static App getApplication() {
        return application;
    }

}
