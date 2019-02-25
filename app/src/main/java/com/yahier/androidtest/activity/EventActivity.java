package com.yahier.androidtest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.util.YahierEventManager;
import com.yahier.androidtest.vo.YahierEvent;

import java.util.Random;

/**
 * 测试发送广播，接收的方法可以用接口监听和注解两种方式
 */
public class EventActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_event);

        findViewById(R.id.btn1).setOnClickListener(v -> {
            postOne();
        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
            postManyAnnotation();
        });

    }

    private void postManyAnnotation() {
        new Thread(() -> {
            while (true) {
                int type = new Random().nextInt(10);
                YahierEventManager.getInstance().postAnnotation(new YahierEvent(type));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void postOne() {
        int type = new Random().nextInt(10);
        YahierEventManager.getInstance().post(new YahierEvent(type));
    }


    private void postMany() {
        new Thread(() -> {
            while (true) {
                int type = new Random().nextInt(10);
                YahierEventManager.getInstance().post(new YahierEvent(type));
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
