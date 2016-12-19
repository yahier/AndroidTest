package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyReplace {
	public static void main(String args[]) {
		replace("");
		testReplace("yahier is 徐子旺");

	}

	/**
	 * string方法的替代 失败了
	 * 
	 * @param str
	 */
	static void testReplace(String str) {
		str.replace("ya", "徐子旺");
		System.out.println(str);
	}

	/**
	 * 用替代字符 非常强大
	 */
	static void replace(String replace) {
		String a = "love23next234csdn3423javaeye我们....>//";
		String regEx = "[^0-9]";
		String chi = "[^\u4e00-\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(a);
		System.out.println(m.replaceAll(replace).trim());
	}

	/**
	 * 也是替换
	 * 
	 * @param str
	 * @param replacemant
	 */
	static void replace(String str, String replacemant) {
		Pattern p = Pattern.compile("[a-z]+");
		Matcher m = p.matcher(str);
		String s = m.replaceAll(replacemant);
		System.out.println(s);

	}

	/**
	 * 替换首个符号pattern的字符 replaceFirst("y   什么啊    a", "天河");返回 天河 什么啊 a
	 * 
	 * @param str
	 * @param replacemant
	 */

	static void replaceFirst(String str, String replacemant) {
		Pattern p = Pattern.compile("[a-z]+");
		Matcher m = p.matcher(str);
		String s = m.replaceFirst(replacemant);
		System.out.println(s);
	}
}