package wenku;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PicSort {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		get();
	}

	static void get() throws IOException {// ��ȡ�ļ�����
		BufferedReader buff = new BufferedReader(new FileReader(
				"C://Documents and Settings/Administrator/����/Test.txt"));
		String str = buff.readLine();
		String[] ya = str.split(",");
		int[] a = new int[ya.length];
		for (int i = 0; i < a.length; i++) {// ���ַ�����ת��int����
			a[i] = Integer.parseInt(ya[i]);
		}

		// ������aѡ������ ����Ŷ ��������ô��ʾ��ʣ�������ѡ��
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
