package thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试wait notify
 * Created by yahier on 2018/2/23.
 */

public class BlockQueue {
    private List list = new ArrayList<Object>();

    public synchronized Object pop() throws InterruptedException {
        while (list.size() == 0)
            this.wait();
        if (list.size() > 0)
            return list.remove(0);
        else
            return null;
    }

    public synchronized void push(Object obj) {
        list.add(obj);
        this.notify();
        System.out.println("push后notify");
    }


    public static void main(String[] args) {
        BlockQueue blockQueue = new BlockQueue();
        blockQueue.start();
        try {
            Object obj = blockQueue.pop();
            System.out.println(obj);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("e:" + e.getLocalizedMessage());
        }

    }


    private void start() {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        push("yahier");
    }
}
