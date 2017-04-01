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
    private final static ReentrantLock lock = new ReentrantLock();

    public final static void main(String[] args) {

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

}
