package string;

/**
 * ����100�Ľ׳�
 */

import java.math.BigInteger;

public class TestBigInteger {

	public static void main(String[] args) {
		System.out.println(big(BigInteger.valueOf(100)));

	}

	/**
	 * 100�Ľ׳�<br>
	 * �����������Ͷ��� ������������ת��Ϊ��Ӧ�İ�װ����֮�����������<br>
	 * �ӣ�o.add(Object o1) <br>
	 * ����o.subtract(Object o1) <br>
	 * �ˣ�o.multiply(Object o1) <br>
	 * ����o.divide(Object o1)
	 */
	public static BigInteger big(BigInteger b) {
		if (b.equals(BigInteger.valueOf(1L))) {
			return BigInteger.valueOf(1L);
		} else {
			return (b.multiply(big(b.subtract(BigInteger.valueOf(1L)))));
		}
	}
}
