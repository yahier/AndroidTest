package io;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class One {
	String url = "http://wap.yiqibazi.com/androidservicev2.asmx?op=HeHun";
	String man = "哈哈|男|公历|1979|10|21|12|0|否";
	String woman = "嘻嘻|女|公历|1982|1|24|15|0|否";
	String key = "alf98je7dhshaf9g8d8r9d9987f8sa";

	private String uploadFile(String actionUrl) {
		// 不知道写这个 是做什么用，注释掉后 又会上传失败。NND
		String con = "manString=" + man + "&womanString=" + woman + "&key="+ key;
		// String s="manString=%s&womanString=%s&key=%s";
		// s=String.format(s, man,woman,key);
		String end = "\r\n";
		String twoHyphens = "--";
		String boundary = "******";

		DataOutputStream dos = null;
		InputStream is = null;
		String ret = null;
		try {
			URL url = new URL(actionUrl);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url
					.openConnection();
			httpURLConnection.setDoInput(true);
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setUseCaches(false);
			httpURLConnection.setRequestMethod("POST");
			//httpURLConnection.setRequestProperty("Content-type", arg1)
			httpURLConnection.setRequestProperty("Charset", "UTF-8");
			httpURLConnection.setRequestProperty("Content-Type",
					"multipart/form-data;boundary=" + boundary);

			dos = new DataOutputStream(httpURLConnection.getOutputStream());
			dos.writeBytes(twoHyphens + boundary + end);
			// 去掉 写入本地的东西

			// map.compress(Bitmap.CompressFormat.JPEG, 75, dos);

			dos.writeBytes(end);
			dos.writeBytes(twoHyphens + boundary + twoHyphens + end);
			dos.flush();

			is = httpURLConnection.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "utf-8");
			BufferedReader br = new BufferedReader(isr);
			final String result = br.readLine();

			ret = result;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (dos != null)
					dos.close();
				if (is != null)
					is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}
	
	
	

}
