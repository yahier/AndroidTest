package thread;

/**
 * Created by yahier on 17/4/27.
 */


import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yahier on 17/4/27.
 * 一个多线程管理类需要哪些要求呢？
 */

public class ThreadPoolManager {
    static ExecutorService service;
    static ThreadPoolManager manager;

    static {
        service = Executors.newCachedThreadPool();
        manager = new ThreadPoolManager();
    }

    public static ThreadPoolManager getInstance() {
        return manager;
    }

    /**
     * 执行任务，需要返回结果
     *
     * @param runnable
     */
    public void execute(Runnable runnable) {
        service.execute(runnable);
    }


    public Object execute(Callable callable) {
        Object value = service.submit(callable);
        return value;
    }


    /**
     * 想让它实现撤销功能。
     *
     * @return
     */
    public boolean remove() {
        return false;
    }

    public void exit() {

    }
}

