package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Longest {

	/**
	 * @param args
	 *            �������ַ�����I am a sTudenT��ʱ,����ʵĳ���Ϊ7,����Ϊ1�� �������ַ�����word body book
	 *            Try��ʱ,����ʵĳ���Ϊ4,����Ϊ3, �����������ʾ�Ϊ�����
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Longest l = new Longest();
		String str = l.get();
		l.go(str);
	}

	String get() throws IOException {
		BufferedReader buff = new BufferedReader(new InputStreamReader(
				System.in));
		return buff.readLine();
	}

	void go(String str) {//���� we er tyy rty rty��ô�����3 4��
		int longth = 0, count = 0;
		String[] a = str.split(" ");
		for (int i = 0; i < a.length; i++) {// ���ֲ𿪵��ַ����ֱ����
			if (a[i].length() > longth) {
				longth = a[i].length();// ��֤�õ�����ƽ̨
				count = 0;
			} 
				
			if (longth == a[i].length()) {
				count++;
				System.out.println(count+"    11");
			}
		}

		System.out.println(longth + " " + count);
	}
}
