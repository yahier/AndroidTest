package core;

public class Test {
    //初始条件,判断条件,条件改变
    public void test() {
        //这两个for循环的效果是一样的
        //for(int i=0;;){
        for (; ; ) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
            System.out.println("Key:");
        }
    }

    public static void main(String avgs[]) {
        Test t = new Test();
        t.test1();
    }


    private void test1() {
        int basic = 0xff;
        byte a = (byte) 0x92;
        int b = a & basic;
        System.out.println("value:" + a + "," + b);

        byte zero = (byte) 0x01;
        int zero2 = zero & basic;
        System.out.println("zero:" + zero + "," + zero2);

    }
}