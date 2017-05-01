package com.yahier.androidtest;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // test3();
       // test4();
    }


    void test1() {
        try {
            FileInputStream in = openFileInput("yahier");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    void test2() {
        ContentResolver resolver = getContentResolver();
    }

    String pattern = "yyyy年MM月dd日 HH:mm:ss";

    Timer timer;

    void test3() {
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                final Calendar calender = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                String timeFormat = format.format(calender.getTime());
                Log.e(TAG, "test3:" + timeFormat);

            }
        }, 5000, 5000);
    }

    Handler handler;

    void test4() {
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                final Calendar calender = Calendar.getInstance();
                SimpleDateFormat format = new SimpleDateFormat(pattern);
                String timeFormat = format.format(calender.getTime());
                Log.e(TAG, "test4:" + timeFormat);

                sendEmptyMessageDelayed(0, 5000);
            }
        };

        handler.sendEmptyMessageDelayed(0, 5000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeMessages(0);
        timer.cancel();

    }

    private void send(){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("sms:10086"));


    }

//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            return true;
//        }
//        return true;
//    }
}
