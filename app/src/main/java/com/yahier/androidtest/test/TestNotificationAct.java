package com.yahier.androidtest.test;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/3/24.
 */

public class TestNotificationAct extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button btn = (Button) findViewById(R.id.button);
        btn.setText("发通知");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go();
            }
        });


    }


    void go() {
        sendNotification("正在评论");
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                sendNotification("评论好了");
            }
        },2000);
    }




    void sendNotification(String content) {
        final NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
       // Notification notify = new Notification.Builder(this).setContentText(content).build();
        //2.实例化一个通知，指定图标、概要、时间
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.drawable.ic_launcher)
                .setContentTitle("准备发送通知")
                .setTicker(content)
                .setContentText(content);
        Notification n = builder.build();
        n.flags = Notification.FLAG_AUTO_CANCEL;//设置点击后自动消失
        //指定声音
        n.defaults = Notification.DEFAULT_SOUND;
        manager.notify(1, n);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                manager.cancel(1);
            }
        },1000);

    }
}
