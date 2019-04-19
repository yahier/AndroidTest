package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import myutil.Log;

/**
 * Created by yahier on 17/4/1.
 * 重入锁
 */

public class ReentrantLockTest {
    final static String TAG = "ReentrantLockTest";
    static int value;
    private final static ReentrantLock lock = new ReentrantLock();

    public final static void main(String[] args) {
        test1();
        //test2();

    }


    /**
     * 这个测试test写的很好啊
     */
    private static void test1() {
        ExecutorService threadPool = Executors.newCachedThreadPool();

        threadPool.execute(() -> {
            m();
            two();
        });
    }

    public static void m() {
        Log.e(TAG, "lock之前");
        try {
            boolean isLock = lock.tryLock(3, TimeUnit.SECONDS);
            Log.e(TAG, "isLock:" + isLock);
            lock.lock();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            Log.e(TAG, "end");
        }
    }

    private static void two() {
        Log.e(TAG, "two");
    }


    //27:51
    public static void test2() {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 100; i++) {
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

    private static Object handleRead() {
        try {
            lock.lock();
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        Log.e(TAG, "read:" + value);
        return value;


    }


    private static void handleWrite(int index) {
        try {
            lock.lock();
            Thread.sleep(1);
            value = index;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            Log.e(TAG, "write:" + value);
        }
    }
}
