package myutil;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

/**
 * 测试Random 和 SecureRandom
 */
public class RandomTest {

    public static void main(String[] args) {
        //test1();
        //test2();
        //test3();
        test4();
    }

    /**
     * 测试seed
     */
    private static void test1() {
        Random random1 = new Random(100);//参数seed，表示随机算法从该数字开始生成随机数字
        Random random2 = new Random(100);
        Random random3 = new Random();
        Random random4 = new Random();

        Log.e("test1", random1.nextInt() + " " + random2.nextInt() + " " + random3.nextInt() + " " + random4.nextInt());
        Log.e("test1", random1.nextInt(100) + " " + random2.nextInt(100) + " " + random3.nextInt(100) + " " + random4.nextInt(100));

    }


    /**
     * 测试nextInt(int bound)
     */
    private static void test2() {
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            int value1 = random.nextInt(); // （-2的32次方————2的32次方）
            int value2 = random.nextInt(); // （-2的32次方————2的32次方）
            int value3 = random.nextInt(32);// return [0,32)upper bound ,exclusive
            Log.e("test2", "value:" + value1 + " " + value2 + " " + value3);
        }
    }

    /**
     * 测试stream
     */
    private static void test3() {
        Random random = new Random();
        //得到无穷尽的IntStream 下面会阻塞
//        IntStream intStream = random.ints();
//        intStream.forEach(System.out::print);

        //不设定界面 (-2的32次方,2的32次方)
        IntStream intStream2 = random.ints(20);
        intStream2.forEach(System.out::println);

        //设定界面(0,20)
        IntStream intStream3 = random.ints(200, 0, 20);
        intStream3.forEach(System.out::println);
    }

    /**
     * test secureRandom
     * 提供加密的强随机数生成器 (RNG)，要求种子必须是不可预知的，产生非确定性输出
     */
    private static void test4() {
        SecureRandom random1 = null;
        SecureRandom random2 = null;
        try {
            random1 = SecureRandom.getInstance("SHA1PRNG");//NativePRNG
            random2 = SecureRandom.getInstance("SHA1PRNG");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        int value1 = random1.nextInt(30);
        int value2 = random2.nextInt(30);
        Log.e("test4", value1 + " " + value2);

        Provider provider = new Provider("yahier", 1, "test") {
            @Override
            public String getName() {
                return super.getName();
            }
        };


        byte[] seed = new byte[5];
        //todo 这个seed 依然是种子，但会综合其他因素一起来生成随机数
        SecureRandom random3 = new SecureRandom(seed);
        SecureRandom random4 = new SecureRandom(seed);
        SecureRandom random5 = new SecureRandom(seed);
        int value3 = random3.nextInt(30);
        int value4 = random4.nextInt(30);
        int value5 = random5.nextInt(30);
        Log.e("test4", value3 + " " + value4 + " " + value5);
        Log.e("test4", Arrays.toString(seed));
    }


    private static void test5() {
        new RandomThread().start();
    }

    /**
     * ThreadLocalRandom解决多个线程发生的争夺竞争
     */
    private static class RandomThread extends Thread {
        @Override
        public void run() {
            int value = ThreadLocalRandom.current().nextInt(10);
            Log.e("test5", "" + value);

        }
    }


}
