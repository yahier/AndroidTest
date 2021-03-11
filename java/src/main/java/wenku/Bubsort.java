package wenku;

import java.util.Scanner;

public class Bubsort {
	static int[] a = new int[20];

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		get();   
		int tem = 0;
		for (int i = 0; i < a.length; i++) {
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

	static int[] get() {
		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < 20; i++) {
			a[i] = scan.nextInt();
		}

		return a;
	}

}
