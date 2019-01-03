package com.yahier.androidtest.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * activity发送message给service。service接着又把message发送回来。
 * Messager的构造函数里，也可以用IBinder.可以用Handler,
 */
public class ActivityMessenger extends BaseActivity {
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
        Message msgFromClient = Message.obtain(handler, MessengerService.MSG_SAY_HELLO, 0, 108);
        msgFromClient.replyTo = mMessenger;
        //往服务端发送消息
        try {
            messenger.send(msgFromClient);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        btn = (Button) findViewById(R.id.button);
        btn.setOnClickListener(new OnClickListener() {

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
        bindService(new Intent(this, MessengerService.class), mConnection, Context.BIND_AUTO_CREATE);
    }


    //service发送的消息会回到这里，但并不会回到Handler.
    private Messenger mMessenger = new Messenger(new Handler() {
        @Override
        public void handleMessage(Message msgFromServer) {
            switch (msgFromServer.what) {
                case MessengerService.MSG_SAY_HELLO:
                    btn.setText(btn.getText() + "messenger:" + msgFromServer.arg2);
                    break;
            }
            super.handleMessage(msgFromServer);
        }
    });


    //没有起效
    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msgFromServer) {
            btn.setText(btn.getText() + "意外:" + msgFromServer.arg2);
            switch (msgFromServer.what) {
                case MessengerService.MSG_SAY_HELLO:
                    btn.setText(btn.getText() + "handler:" + msgFromServer.arg2);
                    break;
            }
            return false;
        }
    });

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
