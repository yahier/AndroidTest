package myutil;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by yahier on 17/3/27.
 */

public class ThreadPoolExecutorTest {
    public final static void main(String[] args) {
        testNewSingleThreadScheduledExecutor();
    }

    static void testNewSingleThreadScheduledExecutor() {
        ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
        scheduler.schedule(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("你好");
                return null;
            }
        }, 3, TimeUnit.SECONDS);


        submit(scheduler, new Runnable() {
            @Override
            public void run() {
                System.out.println("你好呀");
            }
        });


    }

    public static void submit(ScheduledExecutorService scheduler, Runnable cmd) {
        scheduler.scheduleAtFixedRate(cmd, 0, 3, TimeUnit.SECONDS);
    }
}
