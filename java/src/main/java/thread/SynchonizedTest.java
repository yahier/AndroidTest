package thread;

import myutil.Log;

/**
 * Created by yahier on 17/3/28.
 */

public class SynchonizedTest {
    static String t = "";
    static String yaya = "yaya";

    public final static void main(String[] args) {
        SynchonizedTest test = new SynchonizedTest();
        //t = new SynchonizedTest();
        test.test2();
    }

    //即使是不同线程，two()方法 仍然不能和one()方法同时执行
    void test2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                two();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                three();
            }
        }).start();
    }

    void one() {
        synchronized (t) {
            Log.e("SynchonizedTest", "one开始");
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("SynchonizedTest", "one结束");
    }


    void two() {
        synchronized (t) {
            Log.e("SynchonizedTest", "two");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.e("SynchonizedTest", "two结束");
        }

    }


    //如果也有t代替yaya来锁定，three就可以和two同时执行了
    void three() {
        synchronized (yaya) {
            Log.e("SynchonizedTest", "three");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Log.e("SynchonizedTest", "three结束");
        }

    }

}
