package com.yahier.androidtest.multipleThreads;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.yahier.androidtest.R;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

import static com.yahier.androidtest.multipleThreads.YaThreadManager.getInstance;

/**
 * Created by yahier on 2018/7/19.
 */

public class ThreadPoolAct extends AppCompatActivity {
    private final String TAG = "ThreadPoolAct";
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thread_pool_act);


        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        btn1.setOnClickListener(v -> {
            test1();
        });

        btn2.setOnClickListener(v -> {
            test2();
        });

        btn3.setOnClickListener(v -> {
            test3();
        });

        btn4.setOnClickListener(v -> {
            test4();
        });
    }

    private void test1() {
        Log.e("test1", "invoke");
        getInstance().execute((Runnable) () -> Log.e(TAG, "test1 run"));

        YaScheduledThreadManager.getInstance().startCycle("1", () -> {
            Log.e("test1", "run");
        }, 3);

    }

    private void test2() {
        YaScheduledThreadManager.getInstance().cancel("1");
    }


    private void test3() {
        Log.e("test3", "invoke");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.e("test3", "run");
            }
        }).start();
    }

    private void test4() {
        Log.d("test4", "invoke");
        String value = "default";
        FutureTask<String> futureTask = (FutureTask<String>) YaThreadManager.getInstance().execute(() -> {
            SystemClock.sleep(4000);
            Log.d("test4", "yahier");
            return "yahier";
        });
        try {
            Log.d("test4", "value:" + futureTask.get());
            Log.d("test4", "end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
