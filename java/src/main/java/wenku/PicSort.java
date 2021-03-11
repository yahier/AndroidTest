package wenku;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PicSort {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		get();
	}

	static void get() throws IOException {
		BufferedReader buff = new BufferedReader(new FileReader(
				"C://Documentsest.txt"));
		String str = buff.readLine();
		String[] ya = str.split(",");
		int[] a = new int[ya.length];
		for (int i = 0; i < a.length; i++) {
			a[i] = Integer.parseInt(ya[i]);
		}

		int tem = 0, k = 0;
		for (int i = 0; i < a.length - 1; i++) {
			k = i;
			for (int j = i; j < a.length; j++) {
				if (a[j] < a[k])
					k = j;
			}

			tem = a[i];
			a[i] = a[k];
			a[k] = tem;

		}

		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "   ");
		}

	}
}
