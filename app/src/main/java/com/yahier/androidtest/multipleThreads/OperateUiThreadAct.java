package com.yahier.androidtest.multipleThreads;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/1/5.
 */

public class OperateUiThreadAct extends Activity {
    Button btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        test2();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                test3();
                test4();
            }
        });


        //在这里调用test1 也是可以成功的
        test1();
    }


    void test1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                btn1.setText("早上好 1号");
                Button btn4 = (Button) findViewById(R.id.btn4);
                btn4.setText("会崩溃吗");

            }
        }).start();
    }

    void test2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //需要数据传递，用下面方法；
                Message msg = new Message();
                msg.obj = "你好呀 2号";//可以是基本类型，可以是对象，可以是List、map等
                mHandler.sendMessage(msg);
            }
        }).start();
    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    //完成主界面更新,拿到数据
                    String data = (String) msg.obj;
                    btn2.setText(data);
                    break;
                default:
                    break;
            }
        }
    };


    void test3() {
        new Thread() {
            public void run() {
                //这儿是耗时操作，完成之后更新UI；
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //更新UI
                        btn3.setText("你好啊  3号");
                    }
                });
            }
        }.start();
    }

    void test4() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                btn1.post(new Runnable() {
                    @Override
                    public void run() {
                        Button btn4 = (Button) findViewById(R.id.btn4);
                        btn4.setText("test4");
                    }
                });
            }
        }).start();
    }
}
