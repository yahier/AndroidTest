package com.yahier.androidtest.activity;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.util.UiBlock.BlockDetectByChoreographer;
import com.yahier.androidtest.util.UiBlock.BlockDetectByLooper;
import com.yahier.androidtest.util.UiBlock.BlockDetectByPrinter;

/**
 * Created by yahier on 12/29/18.
 * 检测UI线程的卡顿
 */

public class MonitorUiBlockActivity extends BaseActivity {
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_monitor_ui);

        initViews();

    }


    private void initViews() {
        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setText("使用Looper打印的日志监听");
        btn1.setOnClickListener(v -> {
            BlockDetectByPrinter.start();
            SystemClock.sleep(500);
            BlockDetectByPrinter.stop();
        });

        btn2 = (Button) findViewById(R.id.btn2);
        btn2.setText("使用Choreographer");
        btn2.setOnClickListener(v -> {
            BlockDetectByChoreographer.start();
            SystemClock.sleep(500);
        });

        btn3 = (Button) findViewById(R.id.btn3);
        btn3.setText("使用Looper监听");
        btn3.setOnClickListener(v -> {
            BlockDetectByLooper.start();
            SystemClock.sleep(500);
        });
    }
}
