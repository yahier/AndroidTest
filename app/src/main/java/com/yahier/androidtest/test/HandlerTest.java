package com.yahier.androidtest.test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * 测试消息的分发
 * Created by yahier on 17/3/30.
  public void dispatchMessage(Message msg) {
     if (msg.callback != null) {
        handleCallback(msg);
    } else {
       if (mCallback != null) {
         if (mCallback.handleMessage(msg)) {
           return;
         }
       }
      handleMessage(msg);
   }
 * }
 */

public class HandlerTest extends BaseActivity {
    String TAG = "HandlerTest";

    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                start();
            }
        });
    }

    void start() {
        Handler handler2 = new Handler(new MyHandlerCallback());
        MyHandler handler1 = new MyHandler();

        handler2.sendEmptyMessage(1);   // 为什么没有执行上面的Callback的方法呢

//        Message.obtain(handler1, new Runnable() {
//            @Override
//            public void run() {
//                Log.e(TAG, "run。102");
//                button.setText("run了");
//
//
//            }
//        }).sendToTarget();


    }


    class MyHandler extends Handler {
        public MyHandler() {

        }

        public MyHandler(Handler.Callback c) {

        }


        @Override
        public void handleMessage(Message msg) {
            //super.handleMessage(msg);
            Log.e(TAG, "消息来了。101");
        }
    }


    private class MyHandlerCallback implements Handler.Callback {
        @Override
        public boolean handleMessage(Message msg) {
            // Handle messages.
            Log.e(TAG, "tag4");
            return false;
        }
    }


    public class HandlerDemo {
        private Handler myHandler1 = new Handler(new MyHandlerCallback());
        private Handler myHandler2 = new MyHandler();

        private class MyHandlerCallback implements Handler.Callback {
            @Override
            public boolean handleMessage(Message msg) {
                // Handle messages.
                Log.e(TAG, "tag4");
                return false;
            }
        }

        private class MyHandler extends Handler {
            @Override
            public void handleMessage(Message msg) {
                // Handle messages.
                Log.e(TAG, "tag5");
            }
        }
    }
}
