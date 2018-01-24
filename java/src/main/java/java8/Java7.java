package java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by yahier on 2018/1/23.
 * 测试java7的一些方法
 */

public class Java7 {
    static String filePath = "/Users/yahier/Desktop/test2";

    public static void main(String[] args) {
        test1();
        try {
            println("test2", test2(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //catch多个异常  测试反射异常
    static void test1() {
        try {
            Class c = Class.forName("core.InVokeMain");
            Method m = c.getDeclaredMethod("go", null);
            m.setAccessible(true);
            m.invoke(c.newInstance(), null);
        } catch (ReflectiveOperationException | SecurityException e) {
            e.printStackTrace();
        }
    }


    //测试 try-with-resources。还不明白
    static String test2(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }


    static void println(String tag, String value) {
        System.out.println(tag + "," + value);
    }
}
