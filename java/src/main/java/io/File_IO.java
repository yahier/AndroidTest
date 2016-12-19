package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class File_IO {
	public static void main(String args[]) {
		// write("D://line.txt");
		// read();
	}

	static void write(String path) {
		int b;
		byte buffer[] = new byte[120];
		String con = "一起做过的日子";
		try {

			b = System.in.read(buffer);
			System.out.println("b is  " + b);
			FileOutputStream writefile = new FileOutputStream(path);
			writefile.write(con.getBytes());
		} catch (IOException e) {
			System.out.println("Error " + e);
		}
	}

	static void read() {
		try {
			java.io.FileInputStream in = new java.io.FileInputStream(
					"D://line1.txt");
			InputStreamReader buf = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(buf);
			byte[] data = new byte[20];
			try {
				System.out.println("skip count" + reader.skip(10));
				System.out.println("read " + reader.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}