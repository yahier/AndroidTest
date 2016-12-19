package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class MyMatcher {
	public static void main(String[] args) {
		tongji();

	}

	static void tongji() {
		String content = "我们都是ab家驹的BEYOND,f4是what .520";
		Pattern ch = Pattern.compile("[\u4e00-\u9fa5]");//统计中文
		//Pattern en = Pattern.compile("[a-zA-Z]");//统计大小写
		//Pattern no = Pattern.compile("[\\d]");//统计数字
		Matcher m = ch.matcher(content);
		int count =0 ;
		while(m.find()){
			count++;
		}
		System.out.println(count);

	}

	/**
	 * 验证邮件地址
	 */
	static void isEmail() {
		String regex = "\\w{1,}@\\w{1,}\56\\w{1,}";
		String str1 = "yahier@sina.com";
		if (str1.matches(regex)) {
			System.out.println(str1 + "是一个Email地址");
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
	 * 部分匹配 就返回true
	 * 
	 * @param str
	 * @return
	 */
	static boolean IsPartMatch(String str) {
		Pattern p = Pattern.compile("[a-z]");
		Matcher m = p.matcher(str);
		System.out.println("最终内容是    " + m.replaceAll("..."));
		// 匹配在任意位置 str中有任何字段满足条件都返回true

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
	 * 匹配首个字符
	 * 
	 * @param str
	 * @return
	 */
	static boolean IsFirstMatch(String str) {
		Pattern p = Pattern.compile("[a-z]");
		Matcher m = p.matcher(str);
		// 匹配str最前面的一位？
		boolean b = m.lookingAt();
		System.out.println("b is " + b);
		return b;
	}

	/**
	 * 此方法混乱 暂时不被用到
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
		// 从截取点 将后面的字符街上
		m.appendTail(sb);
		String s = sb.toString();
		System.out.println(s);

	}
}
