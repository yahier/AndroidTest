package array;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class AESUtil {
	private static final String AES = "AES";
	private static final String CHARSET_NAME = "utf-8";

	/**
	 * 获取密钥
	 * 
	 * @param password
	 *            加密密码
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	private static SecretKeySpec getKey(String password)
			throws NoSuchAlgorithmException {
		// 密钥加密器生成器
		KeyGenerator kgen = KeyGenerator.getInstance(AES);
		kgen.init(128, new SecureRandom(password.getBytes()));

		// 创建加密器
		SecretKey secretKey = kgen.generateKey();
		byte[] enCodeFormat = secretKey.getEncoded();

		SecretKeySpec key = new SecretKeySpec(enCodeFormat, AES);

		return key;
	}

	/**
	 * 加密
	 * 
	 * @param str
	 *            原文
	 * @param password
	 *            加密密码
	 * @return
	 */
	public static String encode(String str, String password) {
		byte[] arr = encodeToArr(str, password);
		return byteArrToString(arr);
	}

	/**
	 * 
	 * 加密
	 * 
	 * @author wuhongbo
	 * @param str
	 *            原文
	 * @param password
	 *            加密密码
	 * @return
	 */
	private static byte[] encodeToArr(String str, String password) {
		try {
			Cipher cipher = Cipher.getInstance(AES);// 创建密码器
			byte[] byteContent = str.getBytes(CHARSET_NAME);

			cipher.init(Cipher.ENCRYPT_MODE, getKey(password));// 初始化
			byte[] result = cipher.doFinal(byteContent);

			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * 解密
	 * 
	 * @param hexStr
	 *            密文
	 * @param password
	 *            加密密码
	 * @return
	 */
	public static String decode(String hexStr, String password) {
		byte[] arr = string2ByteArr(hexStr);
		return decode(arr, password);
	}

	/**
	 * 解密
	 * 
	 * @author wuhongbo
	 * @param arr
	 *            密文数组
	 * @param password
	 *            加密密码
	 * @return
	 */
	private static String decode(byte[] arr, String password) {
		try {
			// 创建密码器
			Cipher cipher = Cipher.getInstance(AES);
			cipher.init(Cipher.DECRYPT_MODE, getKey(password));// 初始化

			byte[] result = cipher.doFinal(arr);
			return new String(result, CHARSET_NAME);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * byte数组转成16进制字符串
	 * 
	 * @param arr
	 * @return
	 */
	private static String byteArrToString(byte[] arr) {
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < arr.length; i++) {

			String s = Integer.toString(arr[i] + 128, 16);
			if (s.length() == 1) {
				s = "0" + s;
			}

			sb.append(s);
		}

		return sb.toString().toUpperCase();
	}

	/**
	 * 16进制字符串转成byte数组
	 * 
	 * @param arr
	 * @return
	 */
	private static byte[] string2ByteArr(String s) {
		s = s.toUpperCase();
		String str = "0123456789ABCDEF";

		byte[] arr = new byte[s.length() / 2];

		for (int i = 0; i < arr.length; i++) {
			char s1 = s.charAt(i * 2);
			char s2 = s.charAt(i * 2 + 1);

			int tmp1 = str.indexOf(s1) * 16;
			int tmp2 = str.indexOf(s2);

			arr[i] = (byte) (tmp1 + tmp2 - 128);

		}

		return arr;
	}

	public static void main(String[] args) {
		String password = "yahier";
		String content = "123456";
		System.out.println("原文：" + content);

		String hexStr = encode(content, password);
		System.out.println("密文长度：" + hexStr.length());
		System.out.println("密文：" + hexStr);
		System.out.println("解密：" + decode(hexStr, password));
	}

}