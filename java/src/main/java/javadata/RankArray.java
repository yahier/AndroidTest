package javadata;

import java.util.Arrays;

public class RankArray {
	static int[] a = { 1, 2, 3 };

	public static void main(String[] args) {
		rank();
	}

	static void rank() {
		int size = a.length;

		for (int i = 0; i < size; i++) {
			int[] b = new int[3];
			b[0] = i + 1;
			for (int j = 0; j < size && j != i; j++) {
				b[1] = j + 1;
				for (int k = 0; k < size && k != i && k != j; k++) {
					b[2] = k + 1;
					System.out.println(Arrays.toString(b));
				}
				
				
			}

		}
	}

}
