package wenku;

import java.util.Scanner;

public class Bubsort {
	static int[] a = new int[20];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		get();   
		int tem = 0;
		for (int i = 0; i < a.length; i++) {//冒泡排序 从小到大
			for (int j = 0; j < i; j++) {
				if (a[i] < a[j]) {
					tem = a[i];
					a[i] = a[j];
					a[j] = tem;
				}
			}

		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}

	}

	static int[] get() {//接收控制台输入的20个整数
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 20; i++) {
			a[i] = scan.nextInt();
		}

		return a;
	}

}
