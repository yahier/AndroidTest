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
		StringTokenizer fenxi = new StringTokenizer(s, " "); // 参数是要解析的字符串和分隔符
		int number = fenxi.countTokens();// 计算在异常前可调用nextToken的次数
		while (fenxi.hasMoreTokens()) {
			String str = fenxi.nextToken();
			System.out.print(str + "  ");
			System.out.println("还剩" + fenxi.countTokens() + "个单词");
		}

	}

	static void compare() {
		String s1 = "a";
		String s2 = s1 + "b";
		System.out.println(s2.equals("ab"));
	}
}
