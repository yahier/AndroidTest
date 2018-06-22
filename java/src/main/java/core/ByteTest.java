package core;

/**
 * Created by yahier on 2018/5/9.
 */

public class ByteTest {
    public static void main(String[] args) {
        test();
        //test1();
    }

    static void test(){
        byte b = (byte) 0XFF;
        int b2 = (byte)0xcc;
        int i = b;
        int i2 = adjustIn255(b);
        System.out.println("i:" + i + " " + i2 +" "+b2);
    }

    static void test1() {
        byte b = (byte) 0XFF;
        int i = b;
        int i2 = adjustIn255(b);
        System.out.println("i:" + i + " " + i2);

    }

    private static int adjustIn255(byte value) {
        int basic = 0XFF;
        return value & basic;
    }
}
