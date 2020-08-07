package string;

/**
 * 测试BigInteger
 */

import java.math.BigInteger;

public class TestBigInteger {

    public static void main(String[] args) {
        System.out.println(big(BigInteger.valueOf(100)));

    }

    /**
     * 计算从1到b的阶乘
     * �ӣ�o.add(Object o1) <br>
     * ����o.subtract(Object o1) <br>
     * �ˣ�o.multiply(Object o1) <br>
     * ����o.divide(Object o1)
     */
    private static BigInteger big(BigInteger b) {
        if (b.equals(BigInteger.valueOf(1L))) {
            return BigInteger.valueOf(1L);
        } else {
            return (b.multiply(big(b.subtract(BigInteger.valueOf(1L)))));
        }
    }
}
