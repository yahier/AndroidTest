package string;

import java.util.Scanner;

public class OnScanner {
	static String time = "1989��2��23��";
	static String date = "2012-12-26";

	public static void main(String[] args) {
		System.out.println(changeFormat(date));
	}

	/**
	 * ��2012-3-20ת����2012��3��30��
	 */
	static String changeFormat(String time) {
		String[] array = time.split("-");
		return array[0] + "��"+(array[1]) + "��" + array[2] + "��";
	}

}
