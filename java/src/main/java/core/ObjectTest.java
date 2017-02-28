package core;

import java.util.Objects;

/**
 * Created by yahier on 17/2/27.
 */

public class ObjectTest {
    public final static void main(String[] args) {
        ObjectTest client = new ObjectTest();
        //client.test1();
        //client.test2();
        client.test3();
    }


    void test1() {
        String a = "a";
        String b = null;
        if (a.equals(b)) {
            System.out.println("你好啊");
        } else {
            System.out.println("哎哟");
        }


        if (Objects.equals(b, a)) {
            System.out.println("a 你好啊");
        } else {
            System.out.println("a 哎哟");
        }
    }

    void test2() {
        int a = 12;
        int b = 12;
        Integer c = 129;
        Integer d = 129;
        if (new Integer(a) == (new Integer(b))) {
            System.out.println("test2 if");
        } else {
            System.out.println("test2 else");
        }
        //在 -128——127之外的数据,以下两个测试的结果不同喔。统一用equals方法吧
        if (c == d) {
            System.out.println("test2-2 if");
        } else {
            System.out.println("test2-2 else");
        }

        if (c.equals(d)) {
            System.out.println("test2-3 if");
        } else {
            System.out.println("test2-3 else");
        }
    }


    void test3() {
        String a = "a,b,c,,";
        String[] arrays = a.split(",");
        //数组长度只有3
        System.out.println("test3 size:" + arrays.length);
    }
}
