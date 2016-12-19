package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataIo {
	static String path = "d://dataio.txt";

	public static void main(String args[]) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			DataOutputStream out_data = new DataOutputStream(fos);
			out_data.writeInt(100);
			out_data.writeInt(10012);
			out_data.writeLong(123456);
			out_data.writeUTF("yahier is doign what");
			
		} catch (IOException e) {
			System.out.println("write..."+e.getMessage());
		}
		try {
			FileInputStream fis = new FileInputStream(path);
			DataInputStream in_data = new DataInputStream(fis);
			System.out.println(":.." + in_data.readUTF());
			System.out.println(":" + in_data.readInt());//
			System.out.println(":" + in_data.readInt());// 
			System.out.println(":" + in_data.readLong()); 
			
		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
		System.out.println(123);
	}

}
