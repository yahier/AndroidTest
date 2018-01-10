package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yahier on 17/11/6.
 */

public class ThreadPoolFixedTest {
    public final static void main(String[] args) {
        test1();
    }

    static void test1() {
        ExecutorService pools = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 10; i++) {
            final int j = i;
            pools.submit(() -> {
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("....i:" + j);
                if (j == 2) {
                    pools.submit(() -> {
                        System.out.println("哈哈哈哈");

                    });
                }
            });
        }

        pools.shutdown();
    }


}
