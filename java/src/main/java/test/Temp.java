package test;

/**
 * Created by yahier on 17/2/8.
 */

public class Temp {

    public final static void main(String[] args) {
        int a = 0;
        String s1 = "ya";
        bin(a, s1);
        System.out.println("a和s1分别是:" + a + "——" + s1);
    }


    /**
     * 当调用 f(a, s1) 时，变量 a 和 s1 的值被赋给参数 i 和 s，
     * 然后才执行 f 方法。也就是说，无论 i 和 s 怎么变，都不会影响 a 和 s1 的值
     */
    static void bin(int i, String s) {
        i = 100;
        s = "Hi!";
    }

}
