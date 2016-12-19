package array;

/**
 * 我的加密和解密
 * @author lenovo
 *
 */
public class Code {
	private static char[] base64EncodeChars = new char[] { 'A', 'B', 'C', 'D',
			'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
			'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
			'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3',
			'4', '5', '6', '7', '8', '9', '+', '/' };

	public static void main(String[] args) {
		String tag = "3";
		tag = encode(tag);
		System.out.println(tag);
		tag = decode(tag);
		System.out.println(tag);

	}

	// 加密
	private static String encode(String str) {
		StringBuffer sb = new StringBuffer();
		char[] data = str.toCharArray();

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < base64EncodeChars.length; j++) {
				if (base64EncodeChars[j] == data[i]) {
					sb.append(base64EncodeChars[j + 3]);
					continue;
				}
			}
		}
		return sb.toString();
	}

	// 解码
	static String decode(String str) {
		StringBuffer sb = new StringBuffer();
		char[] data = str.toCharArray();

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < base64EncodeChars.length; j++) {
				if (base64EncodeChars[j] == data[i]) {
					sb.append(base64EncodeChars[j - 3]);
					continue;
				}
			}
		}
		return sb.toString();
	}
}
