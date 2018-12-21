package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import myutil.Log;

/**
 * Created by yahier on 17/4/4.
 * reentrantReadWriteLock可重入读写锁
 */

public class ReentrantReadWriteLockTest {
    private final static String TAG = "ReentrantReadWriteLockTest";
    private static Lock readLock;
    private static Lock writeLock;
    private static int value;


    public final static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        readLock = reentrantReadWriteLock.readLock();
        writeLock = reentrantReadWriteLock.writeLock();


        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            final int j = i;
            service.submit((Callable) () -> {
                if (j % 2 == 0) {
                    handleRead();
                } else {
                    handleWrite(j);
                }
                return null;
            });
        }


    }

    //为什么读的时候 也要加锁呢。
    public static Object handleRead() {
        //Log.addPreDate(TAG, "read:开始");
        try {
            readLock.lock();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        Log.addPreDate(TAG, "read:" + value);
        return value;


    }


    public static void handleWrite(int index) {
        try {
            writeLock.lock();
            Thread.sleep(1000);
            value = index;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally

        {
            writeLock.unlock();
        }
    }

}
