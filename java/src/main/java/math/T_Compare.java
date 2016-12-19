package math;

import java.util.Arrays;
import java.util.Scanner;

import classic.Triangle;

public class T_Compare {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T_Compare t = new T_Compare();
		t.bubble();
	}

	public void Array() {
		Scanner s = new Scanner(System.in);
		int a, b, c, min, max;
		a = s.nextInt();
		b = s.nextInt();
		c = s.nextInt();
		int[] m = { a, b, c };
		Arrays.sort(m);
		System.out.println(m[0] + " " + m[1] + " " + m[2]);

		new Triangle().bubble();

	}

	// ��������ܶ������...

	private void judge(int a, int b, int c) { // �Ӵ�С
		if (a >= b) {
			if (a >= c && b <= c)
				System.out.println(a + "" + c + "" + b + "...1");
			if (a >= c && b > c)
				System.out.println(a + "" + b + "" + c + "...2");
			if (a < c)
				System.out.println(c + "" + b + "" + a + "...3");
		} else {
			if (a <= c && b <= c)
				System.out.println(c + "" + b + "" + a + "...4");
			if (a <= c && b > c)
				System.out.println(b + "" + c + "" + a + "...5");
			if (a > c)
				System.out.println(b + "" + a + "" + c + "...6");
		}
	}

	// come on ��ð�ݰ� ��С���������  ����������أ�
	void bubble() { //
		int[] a = { 12, 4, 65, 7, 8};
		int mid; // ���ڽ������м����
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					mid = a[i];
					a[i] = a[j];
					a[j] = mid;
				}
			}
			System.out.print(a[i] + " ");

		}
	}
	
	
}
