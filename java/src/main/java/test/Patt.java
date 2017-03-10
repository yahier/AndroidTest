package test;

import java.util.regex.Pattern;

public class Patt {

    public static void main(String[] args) {
        test1();
    }

    static boolean t() {
        boolean b = Pattern.matches("\\d#\\d#\\d#", "5#2#6#");
        return b;
    }

    static void test1() {
        int a;
        int b = (a = 12);

        System.out.println(a + ":" + b);
    }
}
