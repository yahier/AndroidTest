package array;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AesTest {
	public static String encode(String str, String key)
			throws NoSuchAlgorithmException, NoSuchPaddingException,
			InvalidKeyException, InvalidAlgorithmParameterException,
			IllegalBlockSizeException, BadPaddingException {
		byte[] raw = key.getBytes();
		SecretKeySpec keySpec = new SecretKeySpec(raw, "AES");
		Cipher cipher = Cipher.getInstance("");
		IvParameterSpec iv = new IvParameterSpec("".getBytes());
		cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
		byte[] encrypted = cipher.doFinal(str.getBytes());
		// return Base64.
		return null;
	}

}
