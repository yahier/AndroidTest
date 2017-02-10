package com.yahier.androidtest.multipleThreads;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/2/10.
 * 测试HandlerThread,感觉不错
 */

public class TestHandlerThreadAct extends Activity implements View.OnClickListener {
    MyHandler mHandler;
    String tag = "TestHandlerThreadAct";

    final int msg1_sleep5000 = 1;
    final int msg1_donothing = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);

        init();
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setText("发送一个sleep");
        btn1.setOnClickListener(this);

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setText("直接打印");
        btn2.setOnClickListener(this);

    }


    void init() {
        HandlerThread thread = new HandlerThread("Yahier");
        thread.start();
        Looper mLooper = thread.getLooper();
        mHandler = new MyHandler(mLooper);
    }


    void send1() {
        mHandler.sendEmptyMessage(msg1_sleep5000);
    }

    void send2() {
        mHandler.sendEmptyMessage(msg1_donothing);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                send1();
                break;
            case R.id.btn2:
                send2();
                break;
        }
    }

    class MyHandler extends Handler {

        MyHandler(Looper looper) {
            super(looper);
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case msg1_sleep5000:
                    sleep5S();
                    break;
                case msg1_donothing:
                    Log.e(tag, "啥都不做");
                    break;
            }
        }
    }

    void sleep5S() {
        try {
            Log.e(tag, "睡觉之前");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e(tag, "睡醒了");
    }

}
