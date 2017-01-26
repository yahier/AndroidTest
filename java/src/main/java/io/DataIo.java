package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 读写的顺序不能更改。
 */
public class DataIo {
	static String path = ObjIO.filePath;

	public static void main(String args[]) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			DataOutputStream out_data = new DataOutputStream(fos);
			out_data.writeInt(100);
			out_data.writeInt(12);
			out_data.writeLong(986736783);
			out_data.writeUTF("yahier is doign what");
			out_data.flush();
			fos.flush();
			
		} catch (IOException e) {
			System.out.println("write..."+e.getMessage());
		}
		try {
			FileInputStream fis = new FileInputStream(path);
			DataInputStream in_data = new DataInputStream(fis);
			System.out.println(in_data.readInt());
			System.out.println(in_data.readInt());
			System.out.println(in_data.readLong());
			System.out.println(in_data.readUTF());

		} catch (IOException e) {
			System.out.println(e.getStackTrace());
		}
	}

}
