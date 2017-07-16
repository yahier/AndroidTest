package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

import myutil.Log;

/**
 * Created by yahier on 17/4/1.
 */

public class ReentrantLockTest {
    final static String TAG = "ReentrantLockTest";
    static int value;
    private final static ReentrantLock lock = new ReentrantLock();

    public final static void main(String[] args) {
        test2();

    }

    private void test1() {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                m();
                return null;
            }
        });

        threadPool.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                m();
                two();
                return null;
            }
        });
    }

    public static void m() {
        Log.e(TAG, "lock之前");
        try {
            //boolean isLock = lock.tryLock(10, TimeUnit.MILLISECONDS); // block until condition holds
            //Log.e(TAG, "isLock:" + isLock);
            lock.lock();
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            Log.e(TAG, "end");
        }
    }

    public static void two() {
        Log.e(TAG, "two");
    }


    //27:51
    public static void test2() {
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

    public static Object handleRead() {
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


    public static void handleWrite(int index) {
        try {
            lock.lock();
            Thread.sleep(1);
            value = index;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally

        {
            lock.unlock();
        }
    }
}
