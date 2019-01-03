package core;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yahier on 12/19/18.
 * for语句的测试
 */

public class TestFor {
    private volatile static int i2 = 2;

    public static void main(String[] args) {
        //test1();
        test2();
        test3();
    }

    private static void test1() {
        for (int i = 0; i < 10; ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test1:" + i);
        }

    }


    private static void test2() {
        boolean isExecuted = true;
        for (; isExecuted; isExecuted = false) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test2:" + i2);
        }

    }


    private static void test3() {
        boolean isExecuted = true;
        for (; i2 < 4; ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test3:" + i2);
        }

    }


    private static void test4() {
        Set<String> set = new HashSet<>();
        set.add("晚风吹吹风");
        set.add("我在吃西瓜");
        set.add("门口池塘荷花摇啊摇");
        set.add("鸟儿渣渣叫");
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            System.err.println(iterator.next());
        }
    }

    //无限循环
    private static void test5() {
        for (; ; ) {
            System.err.println(1);
        }
    }
}
