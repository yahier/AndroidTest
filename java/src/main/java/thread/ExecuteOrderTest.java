package thread;

import myutil.Log;

/**
 * Created by yahier on 17/4/11.
 */

public class ExecuteOrderTest {
    static String TAG = "ExecuteOrderTest";

    public static final void main(String[] args) {
        test();
        test2();
    }

    static void test() {
        Thread thread = new Thread() {
            public void run() {
                Log.e(TAG, "run");
            }
        };

        thread.run();
        Log.e(TAG, "yaya");

    }


    //不明白 >>>
    static void test2() {
        int i = -1;
        int b = i >>> 16;
        int c = 4 << 2;
        Log.e(TAG, b + ":" + c);
    }


}
