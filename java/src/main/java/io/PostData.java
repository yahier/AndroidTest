package io;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class PostData {
	private static HttpURLConnection conn = null;
	public static void main(String[] args) {
		HashMap<String, String> paras = new HashMap<String, String>();
		paras.put("departments", "4");

		try {
			String path="http://124.237.121.75:8989/pandianyi/api/user_list.api";
			InputStream in =sendPOSTRequestForInputStream(path,paras);
			getData(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void getData(InputStream in){
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		try {
			System.out.println(reader.readLine());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static InputStream sendPOSTRequestForInputStream(String path,HashMap<String, String> params) throws Exception {
		StringBuilder entityBuilder = new StringBuilder("");
/*		if (params != null && !params.isEmpty()) {
			for (Map.Entry<String, String> entry : params.entrySet()) {
				entityBuilder.append(entry.getKey()).append('=');
				entityBuilder.append(URLEncoder.encode(entry.getValue(),"UTF-8"));
				entityBuilder.append('&');
			}
			entityBuilder.deleteCharAt(entityBuilder.length() - 1);
		}*/
		
		byte[] entity = entityBuilder.toString().getBytes();
		URL url = new URL(path);
		conn = (HttpURLConnection) url.openConnection();

		conn.setConnectTimeout(5 * 1000);
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		conn.setRequestProperty("Content-Length", String.valueOf(entity.length));
		OutputStream outStream = conn.getOutputStream();
		outStream.write(entity);
		outStream.flush();
		outStream.close();
		if (conn.getResponseCode() == 200) {
			return conn.getInputStream();
		}
		return conn.getInputStream();
	}
	

}
