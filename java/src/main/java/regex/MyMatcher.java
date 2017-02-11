package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MyMatcher {
	public static void main(String[] args) {
		tongji();

	}

	static void tongji() {
		String content = "���Ƕ���ab�ҾԵ�BEYOND,f4��what .520";
		Pattern ch = Pattern.compile("[\u4e00-\u9fa5]");//ͳ������
		//Pattern en = Pattern.compile("[a-zA-Z]");//ͳ�ƴ�Сд
		//Pattern no = Pattern.compile("[\\d]");//ͳ������
		Matcher m = ch.matcher(content);
		int count =0 ;
		while(m.find()){
			count++;
		}
		System.out.println(count);

	}

	/**
	 * ��֤�ʼ���ַ
	 */
	static void isEmail() {
		String regex = "\\w{1,}@\\w{1,}\56\\w{1,}";
		String str1 = "yahier@sina.com";
		if (str1.matches(regex)) {
			System.out.println(str1 + "��һ��Email��ַ");
		}
	}

	static boolean isAllMatch(String str) {
		Pattern p = Pattern.compile("[^\u4e00-\u9fa5]*");
		Matcher m = p.matcher(str);
		boolean b = m.matches();
		System.out.println(b);
		return b;
	}

	/**
	 * ����ƥ�� �ͷ���true
	 * 
	 * @param str
	 * @return
	 */
	static boolean IsPartMatch(String str) {
		Pattern p = Pattern.compile("[a-z]");
		Matcher m = p.matcher(str);
		System.out.println("����������    " + m.replaceAll("..."));
		// ƥ��������λ�� str�����κ��ֶ���������������true

		boolean b = m.find();
		System.out.println("isMatch..." + b);
		System.out.println(m.group() + "   " + m.groupCount());
		return b;
	}

	static void go() {
		String con = "a1b2";
		Pattern p = Pattern.compile("[\\d]");
		Matcher m = p.matcher(con);
		System.out.println(m.replaceFirst("...."));

	}

	/**
	 * ƥ���׸��ַ�
	 * 
	 * @param str
	 * @return
	 */
	static boolean IsFirstMatch(String str) {
		Pattern p = Pattern.compile("[a-z]");
		Matcher m = p.matcher(str);
		// ƥ��str��ǰ���һλ��
		boolean b = m.lookingAt();
		System.out.println("b is " + b);
		return b;
	}

	/**
	 * �˷������� ��ʱ�����õ�
	 * 
	 * @param str
	 */
	static void findToReplace(String str) {
		Pattern p = Pattern.compile("[a-z]+");
		Matcher m = p.matcher(str);
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (m.find()) {
			m.appendReplacement(sb, str);
			System.out.println(i);
			i++;
		}
		// �ӽ�ȡ�� ��������ַ�����
		m.appendTail(sb);
		String s = sb.toString();
		System.out.println(s);

	}
}
