package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Created by yahier on 17/3/6.
 */

public class FutureTaskTest {
    public final static void main(String[] args) {
        FutureTask<String> future = new FutureTask<String>(new RealData(("a")));
        ExecutorService executor = Executors.newFixedThreadPool(1);
        executor.submit(future);

        System.out.println("请求完毕");
        try {
            for (int i = 0; i < 4; i++) {
                Thread.sleep(1000);
                System.out.println(i + "数据:" + future.get());//会等待结果
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }


}
