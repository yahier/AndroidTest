package com.yahier.androidtest.download;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.URL;


import android.os.Environment;

import com.yahier.androidtest.data.HandleAsync;


/**
 * 下载工具类。三个类合下一个文件
 * 
 * @author aokunsang。thanks
 * 
 */
public class FileDownloader {

	private HttpURLConnection conn;

	void down() {

		HandleAsync hand = new HandleAsync();
		hand.excute(new HandleAsync.Listener() {

			@Override
			public void parse(String result) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getResult() {
				FileDownloader load = new FileDownloader();
				try {
					load.download();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}
		});
	}

	/**
	 * 开始下载
	 */
	public void download() throws Exception {
		String path = Environment.getExternalStorageDirectory().getPath() + "/test.flv";
		File file = new File(path);

		HttpConnect connect = new HttpConnect(1);
		int fileSize = 0, threadSize = 3; // 文件长度和线程数
		conn = connect.initConnction();
		conn.connect();
		if (conn.getResponseCode() == 200) {
			fileSize = conn.getContentLength();
			conn.disconnect();
		}

		System.out.println("fileSize is " + fileSize);
		int perthThreadSize = fileSize / 3 + 1; // 每个线程需要下载的文件大小.后面的加1，应该是加2
		RandomAccessFile raf = new RandomAccessFile(file, "rw");
		raf.setLength(fileSize);
		raf.close();

		for (int i = 0; i < threadSize; i++) {
			int startpos = i * perthThreadSize; // 线程开始下载的位置
			RandomAccessFile raff = new RandomAccessFile(file, "rw");
			raff.seek(startpos);
			new myThread(startpos, perthThreadSize, i, raff).start();
		}

	}

	class myThread extends Thread {
		private int startpos;
		private int perThreadSize;
		private int threadId;
		private RandomAccessFile raf;

		public myThread(int startpos, int perThreadSize, int threadId, RandomAccessFile raf) {
			this.startpos = startpos;
			this.perThreadSize = perThreadSize;
			this.threadId = threadId;
			this.raf = raf;
		}

		@Override
		public void run() {
			HttpConnect connect = new HttpConnect(0);
			HttpURLConnection con = connect.initConnction();
			con.setRequestProperty("Range", "bytes=" + this.startpos + "-");
			try {
				InputStream is = con.getInputStream();
				byte[] bt = new byte[1024];
				int length = 0;
				int len = 0;
				while (length < this.perThreadSize && (len = is.read(bt)) != -1) {
					raf.write(bt, 0, len);
					length += len;
				}
				raf.close();
				is.close();
				System.out.println("线程" + threadId + "完成！");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	class HttpConnect {
		private int flag;

		public HttpConnect(int flag) {
			this.flag = flag;
		}

		public HttpURLConnection initConnction() {
			HttpURLConnection connection = null;
			try {
				URL url = new URL(HttpConnectParams.URLSTRING.content);
				connection = (HttpURLConnection) url.openConnection();
				connection.setConnectTimeout(Integer.parseInt(HttpConnectParams.CONNECTTIEMEDOUT.content));
				connection.setRequestMethod(HttpConnectParams.POST.content);
				connection.setRequestProperty(HttpConnectParams.ACCECT.header, HttpConnectParams.ACCECT.content);
				connection.setRequestProperty(HttpConnectParams.ACCECT_LANGAGE.header, HttpConnectParams.ACCECT_LANGAGE.content);
				connection.setRequestProperty(HttpConnectParams.CHARSET.header, HttpConnectParams.CHARSET.content);
				if (flag == 1) {
					connection.setRequestProperty(HttpConnectParams.KEEPCONNECT.header, HttpConnectParams.KEEPCONNECT.content);
				}
			} catch (Exception e) {
				connection = null;
			}
			return connection;
		}
	}
}
