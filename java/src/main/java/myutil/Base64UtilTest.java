package myutil;

public class Base64UtilTest {
	public static void main(String[] args) {
		testBase64();
	}

	static void testBase64Util() {
		byte[] s = Base64Util.decode("abcdefg");
		System.out.println(s.length);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}

		String str = Base64Util.encode(s);
		System.out.println(str);

	}

	static void testBase64() {
		System.out.println("yahier");
		byte[] s = Base64Util.decode("abcdefg");
		System.out.println(s.length);
		for (int i = 0; i < s.length; i++) {
			System.out.println(s[i]);
		}

		String str = Base64Util.encode(s);
		System.out.println(str);

	}

}
