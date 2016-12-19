package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetBaidu {
	public static void main(String[] args) {
		try {
			t();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void t() throws IOException {
		URL u = new URL("http://www.baidu.com/");
		HttpURLConnection conne = (HttpURLConnection) u.openConnection();
		BufferedReader reader = new BufferedReader(new InputStreamReader(conne
				.getInputStream(), "gbk"));
		StringBuffer sb = new StringBuffer();
		String con;
		while (null != (con = reader.readLine())) {
			System.out.println(con);
			sb.append(con);
		}

		File f = new File("C:/Users/lenovo/Desktop/baidu.txt");
		if (!f.exists())
			f.createNewFile();
		
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)));
        //writer.write(sb.toString().getBytes());
		writer.write(sb.toString());
		
		reader.close();
		writer.flush();
		writer.close();
	}

}
