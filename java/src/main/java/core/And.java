package core;

import java.util.ArrayList;
import java.util.List;

public class And {
	static List<Boolean> list = new ArrayList<Boolean>(5);
	protected static String a;
	protected static int b = 2;
	String[] strs;
	static int c = 1;
	static int[] array = new int[5];

	public static void main(String[] args) {
		// new And().ya();
		// new And().aa();
		// System.out.println(0.05+0.01);
		list.add(true);
		list.add(true);
		list.add(true);
		list.add(true);
		// list.add(true);
		new And().testParameter(list);
		new And().testParameterArray(array);
		System.out.println("2 " + list.size());
		System.out.println("2 " + array[0]);
		System.out.println();

		String s = "1";
		And.testStr(s);
		System.out.println("s=" + s); // 实参s引用没变，值也不变

		//
		int a = 1;
		new And().testParameter(a);
		System.out.println("3 " + a);
		//
		String b = "y";
		new And().testParameterStr(b);
		System.out.println("4 "+b);
	}

	void ga() {
		strs = new String[1];
	}

	void ya() {
		list.add(true);
		list.add(true);
		list.add(true);
		list.add(true);
		list.add(true);

		// && �ж�·����
		for (int i = 0; i < 10; i++) {
			if (list.size() > i && list.get(i)) {
				System.out.println(i);
			}
		}
	}

	void test() {
		if (a != null && !a.equals("")) {
			System.out.println(1234);
		} else
			System.out.println(456);
	}

	// continue�������ѭ��
	void aa() {
		int sum = 0;
		for (int i = 0; i < 10; i++) {
			System.out.println(" i  is  " + i);
			if (i == 3)
				continue;
			sum += i;

		}
		System.out.println(sum);
	}

	void testParameter(int a) {
		// a++;
		a = 3;
	}

	void testParameter(List<Boolean> list) {
		list.remove(0);
		list=null;
	}

	void testParameterArray(int[] array) {
		array[0] = 12;
		// System.out.println("1 " + array.length);

	}

	void testParameterStr(String a) {
		//a = "bingo";
		a=a.substring(0);
	}

	public static void testStr(String str) {
		str = "hello";// 型参指向字符串 “hello”
	}
}
