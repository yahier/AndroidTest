package com.yahier.androidtest.test;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/3/31.
 * manifest注册的是 跟随整个app的进程时间。代码注册的，注销后就死了。
 */

public class BroadCastActTest extends Activity {
    MyBraodCastReceiver receiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        receiver = new MyBraodCastReceiver();
        registerReceiver(receiver, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
    }
}
