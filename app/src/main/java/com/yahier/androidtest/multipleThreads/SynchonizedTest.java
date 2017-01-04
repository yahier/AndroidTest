package com.yahier.androidtest.multipleThreads;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.yahier.androidtest.R;

/**
 * Created by lenovo on 2017/1/4.
 */

public class SynchonizedTest extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.synchronized_test);
        test2();
    }


    void test1() {
        one();
        two();
    }

    //即使是不同线程，two()方法 仍然不能和one()方法同时执行
    void test2() {
        one();
        new Thread(new Runnable() {
            @Override
            public void run() {
                two();
            }
        }).start();
    }

    synchronized void one() {
        Log.e("SynchonizedTest", "one开始");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("SynchonizedTest", "one结束");
    }

    synchronized void two() {
        Log.e("SynchonizedTest", "two");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("SynchonizedTest", "two结束");
    }
}
