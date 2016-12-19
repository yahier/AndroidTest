package io;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileInput {
	public static void main(String args[]) {
		int b;
		byte buffer[] = new byte[100];
		try {
			b = System.in.read(buffer); 
			FileOutputStream writefile = new FileOutputStream("D://line.txt");
			writefile.write(buffer, 0, b); 
		} catch (IOException e) {
			System.out.println("Error " + e);
		}
	}
	
	
}