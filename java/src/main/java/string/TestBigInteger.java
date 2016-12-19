package string;

/**
 * 计算100的阶乘
 */

import java.math.BigInteger;

public class TestBigInteger {

	public static void main(String[] args) {
		System.out.println(big(BigInteger.valueOf(100)));

	}

	/**
	 * 100的阶乘<br>
	 * 基础数据类型对象化 基础数据类型转化为相应的包装对象之间的四则运算<br>
	 * 加：o.add(Object o1) <br>
	 * 减：o.subtract(Object o1) <br>
	 * 乘：o.multiply(Object o1) <br>
	 * 除：o.divide(Object o1)
	 */
	public static BigInteger big(BigInteger b) {
		if (b.equals(BigInteger.valueOf(1L))) {
			return BigInteger.valueOf(1L);
		} else {
			return (b.multiply(big(b.subtract(BigInteger.valueOf(1L)))));
		}
	}
}
