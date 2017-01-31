package yufa;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;

import io.ObjIO;

public class PrintWriterDemo {
	final static String filePath = ObjIO.filePath;

	public static void main(String[] args) {
		testFileWriter();
		testFileReader();
	}

	//强大的printWriter 貌似print与write都是一样的
	static void testPrintWriter() {
		PrintWriter pw = null;
		String name = "张松伟";
		int age = 22;
		float score = 32.5f;
		char sex = '男';
		try {
			pw = new PrintWriter(new FileWriter(new File(filePath)), true);
			pw.printf("姓名：%s;年龄：%d;性别：%c;分数：%5.2f;", name, age, sex, score);
			pw.println();
			pw.println("多多指教");
			pw.write(name.toCharArray());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			pw.close();
		}

	}

	static void testFileWriter() {
		try {
			FileWriter f = new FileWriter(filePath);
			f.write("2234567\n");
			f.write("sd收到的");
			f.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	static void testFileReader(){
		try {
			BufferedReader b =new BufferedReader( new FileReader(filePath));
			try {
				String con;
				while((con=b.readLine())!=null){
					System.out.println(con);
				}
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