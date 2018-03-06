package thread;

import pojo.People;

/**
 * Created by yahier on 2018/2/24.
 * 测试线程轮流运行。效果OK
 * notify唤醒当前对象的等待线程，notifyAll唤醒所有的线程
 */

public class ThreadOrderTest {
    private final String tag = "tag";
    private volatile int nextIndex = 0;

    People people = new People();//不保证在程序最开始就执行

    public static void main(String[] args) {
        ThreadOrderTest test = new ThreadOrderTest();
        Thread thread1 = test.new Thread1();
        thread1.start();

        Thread thread2 = test.new Thread2();
        thread2.start();

        Thread thread3 = test.new Thread3();
        thread3.start();


    }

    class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (tag) {
                while (true) {
                    if (nextIndex != 0) {
                        try {
                            tag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("a");
                    nextIndex = 1;
                    tag.notifyAll();
                    //以下还需要wait是因为，在nextIndex被修改的期间，有可能while的循环体执行了两遍
                    try {
                        tag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (tag) {
                while (true) {
                    if (nextIndex != 1) {
                        try {
                            tag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("b");
                    nextIndex = 2;
                    tag.notifyAll();
                    try {
                        tag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    class Thread3 extends Thread {
        @Override
        public void run() {
            synchronized (tag) {
                while (true) {
                    if (nextIndex != 2) {
                        try {
                            tag.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("c\n");
                    nextIndex = 0;
                    tag.notifyAll();
                    try {
                        tag.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

}
