package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ga {
	static String str = "0#1#2#3#4#5#104#105#106#107";

	public static void main(String[] args) {
		// Ga.go(str, 107);
		Ga.split();
		//Ga.ttt();

	}

	static void split() {
		String con = "{yahier is bingo,1989}";
		Pattern p = Pattern.compile("yahier|1989");
		Matcher m = p.matcher(con);
		while (m.find()) {
			String newCon = m.group();
			System.out.println("newCon is " + newCon);
		}
	}

	public static void ttt() {
		String str = "no pains . no Gains.";
		Pattern pattern = Pattern.compile("(\\w)*"); // [a-zA-Z_0-9]
		Matcher matcher = pattern.matcher(str);
		List<String> list = new ArrayList<String>();
		int size = 0, length;
		String temp;
		String result = "";
		while (matcher.find()) {
			temp = matcher.group();
			System.out.println("temp is "+temp);
			list.add(temp);
			length = temp.length();
			if (length > size) {
				size = length;
				result = temp;
			}
		}
		System.out.println(list);
		System.out.println(result);
	}

	static void go(String str, int value) {
		String[] strs = str.split("#");

		StringBuffer sb = new StringBuffer();
		boolean startExchange = false;
		for (int i = 0; i < strs.length; i++) {
			if (value == Integer.parseInt(strs[i])) {
				startExchange = true;
			}

			if (startExchange) {
				if (i + 1 < strs.length)
					strs[i] = strs[i + 1];
			}
		}
		for (int i = 0; i < strs.length - 1; i++) {

			if (i != (strs.length - 2))
				sb.append(strs[i] + "#");
			else
				sb.append(strs[i]);
		}
		System.out.println(Arrays.toString(strs));
		System.out.println(sb.toString());

	}

}
