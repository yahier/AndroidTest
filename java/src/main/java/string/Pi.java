package string;

import java.math.BigInteger;

public class Pi {
    public static void main(String[] args) {
        //calculatePi(9223372036854775807l);
        //testBig();
        System.out.println(big(BigInteger.valueOf(100)).toString());
    }

    static void calculatePi(long m) {
        int a = 1;//
        float sum = 0;
        for (int i = 1; i <= m; i = i + 2) {
            sum = sum + (1.0f / i) * a;
            a = a * (-1);
            System.out.println(sum * 4);
        }
    }

    static void test() {
        for (long i = 2, j = 0; j < 63; i = i * 2, j++) {
            System.out.println(i);
        }
        long a = 9223372036854775807l;
        int b = 2147483647;
    }

    static void testBig() {
        BigInteger big = new BigInteger("92233720368547758070000");
        System.out.println(big.bitCount());
        System.out.println(big.bitLength());
        System.out.println(big.longValue());
    }

    public static BigInteger big(BigInteger b) {
        if (b.equals(BigInteger.valueOf(1L))) {
            return BigInteger.valueOf(1L);
        } else {
            return (b.multiply(big(b.subtract(BigInteger.valueOf(1L)))));
        }
    }


}
