package string;

import java.util.Scanner;

public class OnScanner {
	static String time = "1989年2月23日";
	static String date = "2012-12-26";

	public static void main(String[] args) {
		System.out.println(changeFormat(date));
	}

	/**
	 * 将2012-3-20转换成2012年3月30日
	 */
	static String changeFormat(String time) {
		String[] array = time.split("-");
		return array[0] + "年"+(array[1]) + "月" + array[2] + "日";
	}

}
