package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Longest {

	/**
	 * @param args
	 *            如输入字符串〝I am a sTudenT〞时,最长单词的长度为7,个数为1。 而输入字符串〝word body book
	 *            Try〞时,最长单词的长度为4,个数为3, 即有三个单词均为最长单词
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

	void go(String str) {//输入 we er tyy rty rty怎么会输出3 4呢
		int longth = 0, count = 0;
		String[] a = str.split(" ");
		for (int i = 0; i < a.length; i++) {// 将分拆开的字符串分别检索
			if (a[i].length() > longth) {
				longth = a[i].length();// 保证得到最大的平台
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
