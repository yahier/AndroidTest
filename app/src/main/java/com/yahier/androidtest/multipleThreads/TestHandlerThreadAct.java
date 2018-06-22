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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by yahier on 17/2/10.
 * 测试HandlerThread,感觉不错
 */

public class TestHandlerThreadAct extends Activity implements View.OnClickListener {
    MyHandler mHandler;
    String tag = "TestHandlerThreadAct";

    final int msg1_send = 1;
    final int msg2_read = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);

        init();
        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setText("send");
        btn1.setOnClickListener(this);

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setText("read");
        btn2.setOnClickListener(this);

    }


    void init() {
        HandlerThread thread = new HandlerThread("Yahier");
        thread.start();
        Looper mLooper = thread.getLooper();
        mHandler = new MyHandler(mLooper);
    }


    void send1() {
        mHandler.sendEmptyMessageDelayed(msg1_send,5000);
    }

    void send2() {
        mHandler.sendEmptyMessageDelayed(msg2_read,3000);
    }

    void doRead() {
        Log.e(tag,"doRead start");
        try {
            FileInputStream inputStream = new FileInputStream("/sdcard/yaya.txt");
            byte[] data = new byte[20];
            int c = 0;
            while (c != -1) {
                c = inputStream.read(data);
                Log.e("readContent:", new String(data));
            }
            Log.e(tag,"doRead end");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void doWrite() {
        Log.e(tag,"doWrite");
        try {
            FileOutputStream write = new FileOutputStream("/sdcard/yaya.txt",true);
            write.write("12345".getBytes());
            write.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
                case msg1_send:
                    doWrite();
                    send1();
                    break;
                case msg2_read:
                    doRead();
                    send2();
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
