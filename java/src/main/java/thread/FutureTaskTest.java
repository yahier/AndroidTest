package thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by yahier on 17/3/6.
 */

public class FutureTaskTest {
    static FutureTask<String> task = new FutureTask<String>(new RealData(("a")));

    public final static void main(String[] args) {
        ThreadExecute();
        //poolExecute();
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

    static void ThreadExecute() {
        new Thread(task).start();
        System.out.println("ThreadExecute 请求完毕");
        try {
            Thread.sleep(1000);
            //task.cancel(true);
            System.out.println("准备拿结果");//会等待结果

            for (int i = 0; i < 4; i++) {
                if (task.isDone()) {
                    System.out.println("完成了");
                } else {
                    System.out.println("没完成，稍后再来");
                    Thread.sleep(1000);
                }

            }

            if (!task.isCancelled())
                System.out.println("数据:" + task.get());//会等待结果

            System.out.println("拿到结果之后");//会等待结果
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


}
