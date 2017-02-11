package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyReplace {
	public static void main(String args[]) {
		replace("");
		testReplace("yahier is ������");

	}

	/**
	 * string��������� ʧ����
	 * 
	 * @param str
	 */
	static void testReplace(String str) {
		str.replace("ya", "������");
		System.out.println(str);
	}

	/**
	 * ������ַ� �ǳ�ǿ��
	 */
	static void replace(String replace) {
		String a = "love23next234csdn3423javaeye����....>//";
		String regEx = "[^0-9]";
		String chi = "[^\u4e00-\u9fa5]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(a);
		System.out.println(m.replaceAll(replace).trim());
	}

	/**
	 * Ҳ���滻
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
	 * �滻�׸�����pattern���ַ� replaceFirst("y   ʲô��    a", "���");���� ��� ʲô�� a
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