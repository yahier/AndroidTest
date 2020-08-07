package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import myutil.Log;

/**
 * Created by yahier on 17/4/4.
 * reentrantReadWriteLock可重入读写锁
 * 使用场景可分为读/读、读/写、写/写，除了读和读之间是共享的，其它都是互斥的
 */

public class ReentrantReadWriteLockTest {
    private final static String TAG = "";
    private static Lock readLock;
    private static Lock writeLock;
    private static int value;


    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        readLock = reentrantReadWriteLock.readLock();
        writeLock = reentrantReadWriteLock.writeLock();


        test0();
    }

    /**
     * 读写混合 测试发现同样的互斥的，两次间隔的读操作依然是被锁的。
     */
    private static void test0() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 4; i++) {
            final int j = i;
            service.submit(() -> {
                if (j % 2 == 0) {
                    handleRead();
                } else {
                    handleWrite(j);
                }
            });
        }
    }

    /**
     * 单纯读
     */
    private static void test1() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            service.submit((Runnable) ReentrantReadWriteLockTest::handleRead);
        }
    }

    /**
     * 单纯写
     */
    private static void test2() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 3; i++) {
            service.submit(() -> {
                handleWrite(1);
                return null;
            });
        }
    }


    //为什么读的时候 也要加锁呢。因为 读的锁是共享的
    private static Object handleRead() {
        Log.addPreDate(TAG, "read:开始");
        try {
            readLock.lock();
            Log.addPreDate(TAG, "read:锁住了");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
        Log.addPreDate(TAG, "read:解锁了");
        return value;


    }


    private static void handleWrite(int index) {
        Log.addPreDate(TAG, "write:进入方法");
        try {
            writeLock.lock();
            Log.addPreDate(TAG, "write:锁住了");
            Thread.sleep(5000);
            value = index;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

        Log.addPreDate(TAG, "write:解锁");
    }

}
