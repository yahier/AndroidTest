package core;

import java.util.concurrent.TimeUnit;

/**
 * test wait notify。
 */
class MyObject implements Runnable {
    private Monitor monitor;

    public MyObject(Monitor monitor) {
        this.monitor = monitor;
    }

    public void run() {
        try {
            System.out.println("object wait 3");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("开始恢复 i'm going.");
            monitor.invoke();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Monitor implements Runnable {
    private volatile boolean go = false;

    public void run() {
        try {
            watching();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void invoke() throws InterruptedException {
        go = true;
        notify();
    }

    public synchronized void watching() throws InterruptedException {
        //while(go==false)
        if (go == false) {
            System.out.println("111  monitor wating()");
            wait();
        }
        System.out.println("He has gone.");
    }
}

public class Wait {
    public static void main(String[] args) {
        Monitor monitor = new Monitor();
        new Thread(monitor).start();
        //唤醒方法1
        try {
            System.out.println("object sleep");
            TimeUnit.SECONDS.sleep(4);
            System.out.println("开始恢复");
            monitor.invoke();
            //monitor.notify();//notify也需要和wait同一个线程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //唤醒方法2
        MyObject o = new MyObject(monitor);
       new Thread(o).start();
    }
}