package core;

import java.util.Random;

/**
 * 还需要继续测试 Random类的其它方法
 */
public class Test_random {
    public static void main(String[] args) {
        Random d = new Random();
        int ranNo = d.nextInt(2);
        System.out.println(ranNo + "-" + ranNo % 2);
    }
}

