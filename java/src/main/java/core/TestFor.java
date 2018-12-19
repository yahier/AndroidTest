package core;

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
}
