package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 测试在多线程中得到汇合结果
 */
public class TestGetResult {

    public static void main(String[] args) {
        System.out.println("main");
        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        Callable<String> call1 = () -> get1();

        Callable<String> call2 = () -> get2();

        Future<String> future1 = threadPool.submit(call1);
        Future<String> future2 = threadPool.submit(call2);

        if (future1.isDone()) {
            System.out.println("future1 is done");
        }

        if (future2.isDone()) {
            System.out.println("future2 is done");
        }

        try {
            String result1 = future1.get();
            String result2 = future2.get();
            System.out.println("resultOne:" + result1 + "-" + result2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //这个isDone方法有点搞笑，如果上面没有调用get方法，就不会isDone
        if (future1.isDone() && future2.isDone()) {
            try {
                String result = future1.get() + "-" + future2.get();
                System.out.println("resultTwo:" + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }


    private static String get1() {
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "yahier";

    }

    private static String get2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "soso";

    }

}
