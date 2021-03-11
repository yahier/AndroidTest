package string;

public class OnScanner {
	static String date = "2012-12-26";

	public static void main(String[] args) {
		System.out.println(changeFormat(date));
	}

	/**
	 */
	static String changeFormat(String time) {
		String[] array = time.split("-");
		return array[0] + "--"+(array[1]) + "--" + array[2] + "--";
	}

}
