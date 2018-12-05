package math;

/**
 * Created by yahier on 12/4/18.
 */

public class TestAccumulate {
    public static void main(String[] args) {
        test1();
    }

    private static void test1() {
        int a = -2;
        int b = a >> 1;
        int c = a << 1;
        int d = a >>> 1;//无符号右移，忽略符号位，空位都以0补齐
        System.out.println(a + ":" + b + ":" + c + ":" + d);
    }
}
