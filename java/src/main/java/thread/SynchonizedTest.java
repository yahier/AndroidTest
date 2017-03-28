package thread;

import myutil.Log;

/**
 * Created by yahier on 17/3/28.
 */

public class SynchonizedTest {
    static SynchonizedTest t;

    public final static void main(String[] args) {
        SynchonizedTest test = new SynchonizedTest();
        t = new SynchonizedTest();
        test.test2();
    }

    //即使是不同线程，two()方法 仍然不能和one()方法同时执行
    void test2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                one();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                two();
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


}
