package core;

/**
 * Created by yahier on 2018/3/12.
 */

public class TestFinally {
    public static void main(String[] args) {
        int a = test();
        System.err.println("a:" + a);
    }

    static int test() {
        int a = 1;
        try {
            a = 9 / 0;
            return 1;
        } catch (Exception e) {
            return 2;
        } finally {
            a = 3;
            //return 3;//如若这里没有return，则返回try中的值，finally的变量修改不起效果
        }
    }
}
