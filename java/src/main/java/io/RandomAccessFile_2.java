package io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFile_2 {
	static RandomAccessFile in_and_out = null;

	public static void main(String args[]) {
		try {
			in_and_out = new RandomAccessFile("d://tom.txt", "rw");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		te1();
		te_read();
	}

	static void te1() {
		char[] ya = { 'W', 'E', 'A', 'R' };
		try {
			// д��
			for (int i = 0; i < ya.length; i++) {
				// in_and_out.writeChar(ya[i]);
				String s = new String(ya, i, 1);
				// s=new String(s.getBytes(),"UTF-8");
				in_and_out.writeUTF(s);
			}
			in_and_out.seek(0);
			// �� ��
			for (long i = ya.length - 1; i >= 0; i--) {
				// in_and_out.seek(i * 2);
				System.out.print(in_and_out.readUTF());
			}
			System.out.println();
			// in_and_out.close();
		} catch (IOException e) {
		}
	}

	// һ��һ�еĶ�
	static void te_read() {
		try {
			in_and_out.seek(0);
			long filePoint = 0;
			long fileLength = in_and_out.length();

			while (filePoint < fileLength) {
				String s = in_and_out.readLine(); // ����������
				String s1 = new String(s.getBytes(), "UTF-8");
				System.out.println("s is " + s1);
				filePoint = in_and_out.getFilePointer();// ���ص�ǰƫ����
			}
			in_and_out.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
