package io;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

public class T {
	static String s = "  [{‘DocFile’:‘美ᶋϠ阇鿶.doc’,‘ID’:7},{‘DocFile’:‘pandian.docx’,‘ID’:8}]";
	public static void main(String[] args) {
		change("doing something");
	}
	static void change(String s){
		byte[] data = null;
		try {
			data = s.getBytes("gbk");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String con = null;
		try {
			con = new String(data,"gbk");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(con);
	}

}
