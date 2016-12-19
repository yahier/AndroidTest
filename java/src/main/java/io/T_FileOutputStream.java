package io;
import java.io.FileOutputStream;
import java.io.IOException;

public class T_FileOutputStream {
	public static void main(String args[]) {
		int b;
		byte buffer[] = new byte[100];
		try {
			System.out.println("����һ���ı�����������̣�");
			b = System.in.read(buffer); // �ѴӼ���������ַ����buffer
			FileOutputStream writefile = new FileOutputStream("d://yahier.java");
			writefile.write(buffer, 0, 6); // ͨ������ bufferд�뵽�ļ�line.txt
			System.out.println(b);//b��������ֽ����2 ��
		} catch (IOException e) {
			System.out.println("Error " + e);
		}
	}
}

