package wenku;

import java.io.File;

public class DeleteFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Delete("D://ya.java");
	}

	static void Delete(String str) {
		File f = new File(str);
		boolean d = f.delete();
		System.out.println(d);
	}

}
