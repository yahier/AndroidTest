package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class May4 {
	String path = "http://www.baidu.com/";

	public static void main(String[] args) {
		May4 m = new May4();
		m.test();
		m.test2();
	}

	void getData() throws MalformedURLException, IOException {
		List<Integer> list = new ArrayList<Integer>();
		InputStream in = new URL(path).openStream();
		System.out.println("ava is " + in.available());
		int c = -1;
		while (-1 != (c = in.read())) {
			list.add(c);
		}

		System.out.println("list.size is " + list.size());
	}

	void getData1() throws MalformedURLException, IOException {
		InputStream in = new URL(path).openStream();
		StringBuffer sb = new StringBuffer();
		String content;
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		while (null != (content = reader.readLine())) {
			sb.append(content);
		}
		byte[] data = sb.toString().getBytes();
		System.out.println("data.length is  " + data.length);
	}

	void test() {
		String a = "a,b.c";
		Pattern p = Pattern.compile("[,|.]");
		Matcher m = p.matcher(a);
		String con = m.replaceAll("");
		System.out.println("con is " + con);

	}

	void test2() {
		String con = "我y飞sd我fdg";
		Pattern p = Pattern.compile("[a-zA-Z]");
		Matcher m = p.matcher(con);
		System.out.println(m.replaceAll("")); // 输出   我飞我
		
		boolean is = Pattern.matches("\\w*d*", "yahie245");
		System.out.println("is "+is);
	}

}
