package com.yahier.androidtest.view.act;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by yahier on 17/4/2.
 */

public class SurfaceViewTestAct extends com.yahier.androidtest.BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MySurfaceView(this));
    }


    public class MySurfaceView extends SurfaceView implements Runnable, SurfaceHolder.Callback {
        private SurfaceHolder mHolder; // 用于控制SurfaceView
        private Thread t;
        private boolean flag; // 线程运行的标识，用于控制线程
        private Canvas mCanvas;
        private Paint p;
        private int x = 50, y = 50, r = 10; // 圆的坐标和半径

        public MySurfaceView(Context context) {
            super(context);
            mHolder = getHolder();
            mHolder.addCallback(this); // 为SurfaceView添加状态监听
            p = new Paint();
            p.setColor(Color.WHITE);
            setFocusable(true); // 设置焦点
            //没有添加之前，onKeyDown没有反应
            setFocusableInTouchMode(true); ////获得焦点，才能监听键盘事件
        }

        /**
         * 自定义一个方法，在画布上画一个圆
         */
        public void draw() {
            mCanvas = mHolder.lockCanvas();
            mCanvas.drawRGB(0, 0, 0);
            mCanvas.drawCircle(x, y, r, p);
            mHolder.unlockCanvasAndPost(mCanvas);
        }

        /**
         * 当SurfaceView创建的时候，调用此函数
         */
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            t = new Thread(this);
            flag = true;
            t.start();
        }

        /**
         * 当SurfaceView的视图发生改变的时候，调用此函数
         */
        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width,
                                   int height) {
        }

        /**
         * 当SurfaceView销毁的时候，调用此函数
         */
        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            flag = false; // 把线程运行的标识设置成false
        }

        /**
         * 当屏幕被触摸时调用
         */
        @Override
        public boolean onTouchEvent(MotionEvent event) {
            x = (int) event.getX(); // 获得屏幕被触摸时对应的X轴坐标
            y = (int) event.getY(); // 获得屏幕被触摸时对应的Y轴坐标
            return true;
        }

        /**
         * 当用户按键时调用
         */
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN) {  //当用户点击 音量——键
                y = y - 10;  //设置Y轴坐标减1
                Log.e("onKeyDown", "y--" + y);
            }
            return super.onKeyDown(keyCode, event);
        }

        @Override
        public void run() {
            while (flag) {
                draw(); // 调用自定义画画方法
                try {
                    Thread.sleep(50); // 让线程休息50毫秒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}







