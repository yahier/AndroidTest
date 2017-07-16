package test;

import java.util.concurrent.Callable;

import myutil.Log;
import thread.ThreadPoolManager;

/**
 * Created by yahier on 17/4/27.
 */

public class Test {
    static final String TAG = "Test";

    public static final void main(String[] args) {
        test();

    }

    static void test() {
        Log.e(TAG, "test 1");
        ThreadPoolManager.getInstance().execute(new Callable() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(3000);
                Log.e(TAG, "test 醒了");
                return "yahier";
            }
        });
        Log.e(TAG, "test 2");
    }
}
