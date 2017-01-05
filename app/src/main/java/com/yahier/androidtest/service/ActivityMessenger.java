package com.yahier.androidtest.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.yahier.androidtest.R;


public class ActivityMessenger extends Activity {
    /**
     * 向Service发送Message的Messenger对象
     */
    Messenger messenger = null;
    /**
     * 判断有没有绑定Service
     */
    boolean mBound;

    private ServiceConnection mConnection = new ServiceConnection() {
        public void onServiceConnected(ComponentName className, IBinder service) {
            // Activity已经绑定了Service
            // 通过参数service来创建Messenger对象，这个对象可以向Service发送Message，与Service进行通信
            Toast.makeText(getApplicationContext(), "onServiceConnected", Toast.LENGTH_SHORT).show();
            messenger = new Messenger(service);
            mBound = true;
        }

        public void onServiceDisconnected(ComponentName className) {
            messenger = null;
            mBound = false;
        }
    };

    public void sayHello() {
        if (!mBound)
            return;
        // 向Service发送一个Message
        Message msg = Message
                .obtain(null, MessengerService.MSG_SAY_HELLO, 0, 0);
        try {
            messenger.send(msg);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.button).setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                sayHello();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 绑定Service
        bindService(new Intent(this, MessengerService.class), mConnection,
                Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        // 解绑
        if (mBound) {
            unbindService(mConnection);
            mBound = false;
        }
    }
}
