package array;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class DesTest {
	public static void main(String[] args) {
		//test();
		// 待加密内容
		String str = "88990000";
		// 密码，长度要是8的倍数
		String password = "88888888";
		byte[] result = desCrypto(str.getBytes(), password);
		System.out.println("加密后内容为：" + new String(result));
		// 直接将如上内容解密

		String charSet = "gbk";
		byte[] array = new String(result,Charset.forName(charSet)).getBytes(Charset.forName(charSet));
		System.out.println(result.length + "   " + array.length);

		try {
			byte[] decryResult = decrypt(result, password);//换成result
			System.out.println("解密内容为：" + new String(decryResult));
		} catch (Exception e1) {
			e1.printStackTrace();
		}

	}



	static void test() {
		String str = "yahier";
		byte[] data = str.getBytes();
		System.out.println("新str:" + new String(data));

		byte[] data2 = new String(data).getBytes();

		System.out.println("" + new String(data2));
		
		
		String test = "tests1weipdosgpdos";
		byte[] bytes = test.getBytes(Charset.forName("UTF-8"));
		String newStr = new String(bytes, Charset.forName("UTF-8"));
	}

	public static byte[] desCrypto(byte[] datasource, String password) {
		try {
			SecureRandom random = new SecureRandom();
			DESKeySpec desKey = new DESKeySpec(password.getBytes());
			// 创建一个密匙工厂，然后用它把DESKeySpec转换成
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
			SecretKey securekey = keyFactory.generateSecret(desKey);
			// Cipher对象实际完成加密操作
			Cipher cipher = Cipher.getInstance("DES");
			//Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
			// 用密匙初始化Cipher对象
			cipher.init(Cipher.ENCRYPT_MODE, securekey, random);
			// 现在，获取数据并加密
			// 正式执行加密操作
			return cipher.doFinal(datasource);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	private static byte[] decrypt(byte[] src, String password) throws Exception {
		// DES算法要求有一个可信任的随机数源
		SecureRandom random = new SecureRandom();
		// 创建一个DESKeySpec对象
		DESKeySpec desKey = new DESKeySpec(password.getBytes());
		// 创建一个密匙工厂
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		// 将DESKeySpec对象转换成SecretKey对象
		SecretKey securekey = keyFactory.generateSecret(desKey);
		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance("DES");
		 //Cipher cipher = Cipher.getInstance("DES/ECB/NoPadding");
		// 用密匙初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, random);
		// 真正开始解密操作
		return cipher.doFinal(src);
	}

}
