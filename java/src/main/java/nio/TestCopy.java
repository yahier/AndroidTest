package nio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestCopy {
	public static void main(String[] args) {
		try {
			copy2("H:/youku.zip", "H:/youku2.zip");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * byteBuffer 1466ms 1981ms 1350ms
	 * 
	 * @param start
	 * @param end
	 * @throws IOException
	 */
	static void copy(String start, String end) throws IOException {
		long startTime = System.currentTimeMillis();
		FileInputStream in = new FileInputStream(start);
		FileOutputStream out = new FileOutputStream(end);
		FileChannel readChannel = in.getChannel();
		FileChannel writeChannel = out.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		while (true) {
			buffer.clear();
			int len = readChannel.read(buffer);
			if (len == -1) {
				break;
			}
			buffer.flip();
			writeChannel.write(buffer);
		}
		readChannel.close();
		writeChannel.close();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	/**
	 * * 最失败的复制，文件解压失败，速度最慢 5592ms
	 * 
	 * @param start
	 * @param end
	 * @throws IOException
	 */
	static void copy2(String start, String end) throws IOException {
		long startTime = System.currentTimeMillis();
		FileReader in = new FileReader(start);
		FileWriter out = new FileWriter(end);
		BufferedWriter writer = new BufferedWriter(out);
		BufferedReader reader = new BufferedReader(in);
		char[] data = new char[1024 * 8];
		int maxLength = data.length;
		int len;
		while ((len = (reader.read(data,0,maxLength))) != -1) {
			writer.write(data, 0, len);
			writer.flush();
		}

		writer.close();
		reader.close();
		in.close();
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

	/**
	 * 2400ms 1285ms 301ms 323ms 266ms 2717ms 315ms 246ms :不可能啊 这样快速么
	 * 
	 * @param start
	 * @param end
	 * @throws IOException
	 */
	static void copy3(String start, String end) throws IOException {
		long startTime = System.currentTimeMillis();
		FileInputStream in = new FileInputStream(start);
		FileOutputStream out = new FileOutputStream(end);
		byte[] data = new byte[8 * 1024];
		int maxLength = 8 * 1024;
		int length;
		while ((length=in.read(data,0,maxLength)) != -1) {
			out.write(data,0,length);
			out.flush();
		}
		in.close();
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}
}
