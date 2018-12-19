package pattern.model;

/**
 * Created by yahier on 12/19/18.
 * Q1:怎么保证三个方法按固定顺序执行。
 */

public class UpdateManager extends AbsMain {
    private final String TAG = "UpdateManager ";
    private Object remux2 = new Object();
    private Object remux3 = new Object();


    @Override
    protected void method1() {
        new Thread(() -> {
            System.err.println(TAG + "method1 开始");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(TAG + "method1 结束");
            synchronized (remux2) {
                remux2.notify();
            }
        }).start();
    }

    @Override
    protected void method2() {
        synchronized (remux2) {
            try {
                remux2.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        new Thread(() -> {
            System.err.println(TAG + "method2 开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(TAG + "method2 结束");
            synchronized (remux3) {
                remux3.notify();
            }
        }).start();
    }

    @Override
    protected void method3() {
        synchronized (remux3) {
            try {
                remux3.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        new Thread(() -> {
            System.err.println(TAG + "method3 开始");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(TAG + "method3 结束");
        }).start();
    }
}
