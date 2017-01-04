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
        test();
        System.out.println(add());
    }
}