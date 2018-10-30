package thread;

/**
 * Created by yahier on 10/30/18.
 * 测试 死锁
 */

public class Deadlock {

    private String objID;

    private Deadlock(String id) {
        objID = id;
    }


    public static void main(String[] args) {
        final Deadlock obj1 = new Deadlock("obj1");
        final Deadlock obj2 = new Deadlock("obj2");

        Thread threadA = new Thread(() -> {
            obj1.checkOther(obj2);
        }, "threadA");
        threadA.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException x) {
            //pass
        }

        Thread threadB = new Thread(() -> {
            obj2.checkOther(obj1);
        }, "threadB");
        threadB.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException x) {
            //pass
        }

        threadPrint("finished sleeping");

        threadPrint("about to interrupt() threadA");

        threadA.interrupt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException x) {
        }

        threadPrint("about to interrupt() threadB");
        threadB.interrupt();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException x) {
        }

        threadPrint("did that break the deadlock?");
    }


    /**
     * 同时进入了此方法，因为 锁的对象不同
     */
    private synchronized void checkOther(Deadlock other) {
        print("entering checkOther()");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException x) {
        }
        print("in checkOther() - about to " + "invoke 'other.action()'");
        //调用other对象的action方法，由于该方法是同步方法，因此会试图获取other对象的对象锁
        other.action();
        print("leaving checkOther()");
    }

    /**
     * 都不能进入到此方法。
     * 在执行到上面的other.action() 时，由于两个线程都在试图获取对方的锁，但对方都没有释放自己的锁，因而便产生了死锁，在主线程中试图中断两个线程，但都无果
     */
    private synchronized void action() {
        print("entering action()");
        try {
            Thread.sleep(500);
        } catch (InterruptedException x) {
        }
        print("leaving action()");
    }


    public void print(String msg) {
        threadPrint("objID=" + objID + " - " + msg);
    }


    private static void threadPrint(String msg) {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + ": " + msg);
    }
}