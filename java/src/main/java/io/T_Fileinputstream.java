package io;

import java.io.IOException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class T_Fileinputstream {
	public static void main(String args[]) {
		try {
			FileInputStream in = new FileInputStream("D://yahier.java");
			while (in.available() > 0)
				System.out.print(in.read() + "cong   ");
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error: Cannot open file for reading.");
		} catch (EOFException e) {
			System.out
					.println("Error: EOF encountered, file may be corrupted.");
		} catch (IOException e) {
			System.out.println("Error: Cannot read from file.");
		}
	}
}
