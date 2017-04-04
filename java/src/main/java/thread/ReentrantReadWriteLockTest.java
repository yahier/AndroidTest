package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import myutil.Log;

/**
 * Created by yahier on 17/4/4.
 */

public class ReentrantReadWriteLockTest {
    final static String TAG = "ReentrantReadWriteLockTest";
    private static ReentrantReadWriteLock reentrantReadWriteLock;
    private static Lock readLock;
    private static Lock writeLock;
    static int value;


    public final static void main(String[] args) {
        reentrantReadWriteLock = new ReentrantReadWriteLock();
        readLock = reentrantReadWriteLock.readLock();
        writeLock = reentrantReadWriteLock.writeLock();


        //20:54，相比较 重入锁需要27:51
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20000; i++) {
            final int j = i;
            service.submit(new Callable() {
                @Override
                public Object call() throws Exception {

                    if (j % 2 == 0) {
                        handleRead();
                    } else {
                        handleWrite(j);
                    }
                    return null;
                }
            });
        }


    }

    //为什么读的时候 也要加锁呢。
    public static Object handleRead() {
        try {
            readLock.lock();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        Log.e(TAG, "read:" + value);
        return value;


    }


    public static void handleWrite(int index) {
        try {
            writeLock.lock();
            Thread.sleep(1);
            value = index;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally

        {
            writeLock.unlock();
        }
    }

}
