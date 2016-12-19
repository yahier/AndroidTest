package io;

//2010��java���� �㷨������
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Myio {
	Map hashMap = new HashMap();
	int count = 1;

	public static void main(String[] args) {
		Myio io = new Myio();

		try {
			io.te();
		} catch (IOException e) {

			e.printStackTrace();
		}

		InputStream in = Myio.class.getResourceAsStream("student.xml");
		if (in == null)
			System.out.println(123);
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		String con;
		try {
			while ((con = reader.readLine()) != null) {
				System.out.println(con);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void te() throws IOException {
		FileReader read = new FileReader("C://name2.txt");
		BufferedReader buf = new BufferedReader(read);
		StringBuffer sb = new StringBuffer();
		String content;
		while (null != (content = buf.readLine())) {
			// System.out.println(content);
			parse(content);
		}
		// System.out.println(count);
	}

	void parse(String item) {
		Pattern p = Pattern.compile("[^\u4e00-\u9fa5]*");

		Matcher m = p.matcher(item);

		String name = m.replaceAll("");

		Pattern p_score = Pattern.compile("^[\\d]");
		Matcher m_score = p_score.matcher(item);
		String score = m_score.replaceAll("");
		System.out.println("score is " + score);

		if (hashMap.containsKey(name)) {
			System.out.println();
			count++;
		} else
			hashMap.put(name, 1);

	}

}