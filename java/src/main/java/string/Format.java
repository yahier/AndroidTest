package string;

public class Format {
	static int a = 2;

	public static void main(String[] args) {
		System.out.println(changeFormat(a));
	}

	static int changeFormat(int a) {
		if (a < 10) {
			a = Integer.parseInt("0" + a);
		}
		return a;

	}

}
