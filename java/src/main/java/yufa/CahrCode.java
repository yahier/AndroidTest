package yufa;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class CahrCode {
	public static void main(String[] args) {
		//teUnicode();
		//testSystem();
		test();
	}

	static void teUnicode() {
		String s = "中国";
		for (int i = 0; i < s.length(); i++) {
			int a = (int) s.charAt(i);//
		
			String str = Integer.toBinaryString(a);//binary
			String hex = Integer.toHexString(a);//这是Unicode？
			System.out.println(a+"  "+str+"  "+hex);
		}
		System.out.println();
		byte[] data = null;
		data = s.getBytes();
		for(int i=0;i<data.length;i++){
			System.out.print(Integer.toHexString(data[i])+"  ");
			System.out.println(data[i]);
		}
		
		for(int i=0;i<data.length;i++){
			//System.out.print(Integer.toHexString(data[i])+"  ");
			System.out.write(data[i]);
			
		}
		System.out.println();
		System.out.println(data.length);
	}
	
	static void testSystem(){
		System.getProperties().list(System.out);
	}

	static void test(){
		PrintStream p=System.out;
		String con="我";
		p.write(12);
		p.println();
	}
}
