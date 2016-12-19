package io;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Yaio {
	String url = "http://ww4.sinaimg.cn/bmiddle/82252911gw1dwa390c74dj.jpg";

	// ���Խ������� �õ���ͼƬЧ��
	void test(String ur) throws IOException {
		URL url = new URL(ur);
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		InputStream in = new BufferedInputStream(urlConnection.getInputStream());
		byte[] data = new byte[in.available()];
		in.read(data);

	}

}
