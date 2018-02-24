package thread;

/**
 * Created by yahier on 2018/2/24.
 * 测试线程轮流运行
 * notify唤醒当前对象的等待线程，notifyAll唤醒所有的线程
 */

public class ThreadOrderTest {
    boolean is1Run = true;
    boolean is2Run = true;
    static ThreadOrderTest test;

    public static void main(String[] args) {
        test = new ThreadOrderTest();
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
            synchronized (test) {
                while (is1Run) {
                    System.out.println("a");
                    try {
                        test.notify();
                        test.wait();
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
            synchronized (test) {
                while (is2Run) {
                    System.out.println("b");
                    try {
                        test.notify();
                        test.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    class Thread3 extends Thread {
        @Override
        public synchronized void run() {
            while (true) {
                System.out.println("c");
                try {
                    wait(10);//隔500ms自动唤醒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
