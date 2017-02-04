package thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/2/4.
 *  测试Thread.join方法
 */

public class ThreadJoin {
    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("1 i:" + i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("2 i:" + i);
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                    if (i == 2) {
                        try {
                            thread1.join();//阻塞当前的thread2线程，等thread1执行完了。再继续执行当前thread2
                        } catch(InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        thread1.start();
        thread2.start();


    }


}
