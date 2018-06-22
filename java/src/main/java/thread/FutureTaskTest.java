package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * 也算是另一种的Future模式
 * Created by yahier on 17/3/6.
 */

public class FutureTaskTest {
    static FutureTask<String> task = new FutureTask<>(new RealData(("a")));

    public final static void main(String[] args) {
        //ThreadExecute();
        //poolExecute();
        testTimeout();
    }

    static void poolExecute() {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        //Future future = executor.submit(task);
        //future.cancel(true);

        executor.execute(task);
        System.out.println("请求完毕");

        try {
            for (int i = 0; i < 4; i++) {
                Thread.sleep(1000);
                if (!task.isCancelled())
                    System.out.println(i + "数据:" + task.get());//会等待结果
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private static void ThreadExecute() {
        new Thread(task).start();
        System.out.println("ThreadExecute 请求完毕");
        try {
            Thread.sleep(1000);
            //task.cancel(true);
            System.out.println("准备拿结果");//会等待结果

            while (!task.isDone()) {
                System.out.println("没完成，稍后再来");
                Thread.sleep(1000);
            }

            if (!task.isCancelled())
                System.out.println("数据:" + task.get());//会等待结果

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }


    private static void testTimeout() {
        Callable<Integer> call = () -> {
            Thread.sleep(180);
            return 3;
        };
        ExecutorService threadPool = Executors.newFixedThreadPool(1);
        Future<Integer> future = threadPool.submit(call);
        int value = 0;
        try {
            value = future.get(200, TimeUnit.MILLISECONDS);
            System.out.println("value:" + value);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println("value:" + value);
    }
}
