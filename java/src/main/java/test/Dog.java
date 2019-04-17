package test;

import java.util.List;
import java.util.ArrayList;

public class Dog {
    static void test() {
        List<String> list = new ArrayList<String>();
        list.add("hello");

    }

    static int add() {
        int a = 1;
        int b = 1;
        int c = a + b;
        return c;
    }

    public static void main(String[] args) {
        //test();
        //System.out.println(add());

        Cat cat1 = new Cat("soso");
        Cat cat2 = new Cat("yoyo");
        List<Cat> list = new ArrayList<>();
        list.add(cat1);
        list.add(cat2);

        new Thread(() -> {
            try {
                for (Cat cat : list) {
                    System.out.println("name:" + cat.name);
                }
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}