package array;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by yahier on 10/8/18.
 * 使用ArrayList，会出现 ConcurrentModificationException
 * 1.单单用vector 依然有错，加上方法同步，就可以了
 * 2.使用CopyOnWriteArrayList，可以了。
 */

public class TestCopyOnWriteArrayList {


    private static List<Integer> vector = new CopyOnWriteArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            vector.add(i);
        }

        while (true) {
            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    Thread.yield();
                    test1();
                }
            }).start();

            new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    Thread.yield();
                    test2();
                }
            }).start();

        }
    }


    static void test1() {
        List<Integer> list = new ArrayList<>();
        for (int a : vector) {  // ConcurrentModificationException
            list.add(1);
        }

        System.out.println("test1 执行完成");
    }

    static void test2() {
        if (vector.size() > 0)
            vector.remove(0);

        System.out.println("test2 执行完成");
    }

}
