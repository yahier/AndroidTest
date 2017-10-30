package com.yahier.androidtest.test;

import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.R;
import com.yahier.androidtest.vo.TimerRecode;

/**
 * Created by yahier on 17/3/31.
 * manifest注册的是 跟随整个app的进程时间。代码注册的，注销后就死了。
 */

public class BroadCastActTest extends Activity {
    MyBraodCastReceiver receiver;
    Button btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        btn = (Button) findViewById(R.id.button);

        receiver = new MyBraodCastReceiver();
        registerReceiver(receiver, new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED"));

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test(timeAll);
            }
        });

        long timeLeft = TimerRecode.getTimeLeft(getClass().getName());
        if (timeLeft > 0) test(timeLeft);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(receiver);
        TimerRecode.save(getClass().getName(), timeLeft);
    }

    CountDownTimer timer;
    long timeLeft = 0;
    final long timeAll = 60 * 1000;

    void test(long timeAll) {
        timer = new CountDownTimer(timeAll, 1000) {
            @Override
            public void onTick(long time) {
                timeLeft = time;
                if (isFinishing()) {
                    timer.cancel();
                }
                Log.e("timer", "time:" + time / 1000);
                btn.setText("时间:" + time / 1000);
            }

            @Override
            public void onFinish() {

            }
        };
        timer.start();
    }
}
