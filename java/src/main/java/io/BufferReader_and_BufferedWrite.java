package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferReader_and_BufferedWrite {
	public static void main(String args[]) {
		File file = new File("D://Student.txt");
		String content[] = { "erty", "dfghj", "rtyui", "ertyu" };
		try {
			//д��ȥ
			FileWriter outOne = new FileWriter(file);
			BufferedWriter outTwo = new BufferedWriter(outOne);
			for (int k = 0; k < content.length; k++) {
				outTwo.write(content[k]);// Writer���write(String s)
				outTwo.newLine();//
			}
			outTwo.close();
			outOne.close();

		
			FileReader inOne = new FileReader(file);
			BufferedReader inTwo = new BufferedReader(inOne);
			String s = null;
			int i = 0;
			while ((s = inTwo.readLine()) != null) {
				i++;
				System.out.println("..." + i + ":" + s);
			}
			inOne.close();
			inTwo.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
