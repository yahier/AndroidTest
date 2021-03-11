package string;

import java.util.StringTokenizer;

public class StringTokenizer_ {

	/**
	 * @param args
	 */
	public static void main(String args[]) {
		compare();
	}

	static void StringToken() {
		String s = "I am Geng.X.y she is my girlfriend";
		StringTokenizer fenxi = new StringTokenizer(s, " ");
		int number = fenxi.countTokens();//
		while (fenxi.hasMoreTokens()) {
			String str = fenxi.nextToken();
			System.out.print(str + "  ");
			//System.out.println("��ʣ" + fenxi.countTokens() + "������");
		}

	}

	static void compare() {
		String s1 = "a";
		String s2 = s1 + "b";
		System.out.println(s2.equals("ab"));
	}
}
