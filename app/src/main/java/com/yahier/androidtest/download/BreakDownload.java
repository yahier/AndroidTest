package com.yahier.androidtest.download;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.URL;
import java.net.URLConnection;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.yahier.androidtest.R;


/**
 * 断点续传
 * 
 * @author lenovo
 * 
 */
public class BreakDownload extends Activity implements OnClickListener {
	String url = "http://192.168.1.102:8080/hotel/beat.flv";
	String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/beat2.flv";
	TextView text;
	File file;
	volatile boolean isRun = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.down);
		init();
		text = (TextView) findViewById(R.id.text);
		findViewById(R.id.start).setOnClickListener(this);
		findViewById(R.id.pause).setOnClickListener(this);
		findViewById(R.id.stop).setOnClickListener(this);
	}

	// 初始化，包括创建文件
	protected void init() {
		file = new File(path);
		if (!file.exists()) {
			try {
				System.out.println("创建文件:" + file.createNewFile());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.start:
			isRun = true;
			new MyThread(1).start();
			break;
		case R.id.pause:
			isRun = false;
			break;
		case R.id.stop:
			break;
		}

	}

	
	void test2(int part) throws IOException{
		Log.e("break", "execute");
		RandomAccessFile access = new RandomAccessFile(file, "rw");
		// 查看本地文件的字节数。
		long at = access.length();
		URL u = new URL(url);
		URLConnection ur = u.openConnection();
		//服务器跳过
		ur.setRequestProperty("Range", "bytes=" + at + "-");
		InputStream input = ur.getInputStream();
		// 本地跳过
		access.seek(at);
		Log.e("break", "恢复到了位置");
		byte[] buffer = new byte[1024];
		int len;
		while ((len = input.read(buffer)) > 0 && isRun) {
			access.write(buffer, 0, len);
		}
		Log.e("break", "下载完成");
	
	}
	void execute1(int part) throws IOException {
		System.out.println("execute..");
		URL u = new URL(url);
		InputStream input = u.openStream();
		RandomAccessFile access = new RandomAccessFile(file, "rw");
		// 查看本地文件的字节数。
		long at = access.length();
		// 本地跳过
		access.seek(at);
		// input跳过
		while (at > 0) {
			long amt = input.skip(at);
			if (amt == -1) {
				throw new RuntimeException(file + ": unexpected EOF");
			}
			at -= amt;
		}
		System.out.println("恢复到了位置");
		byte[] buffer = new byte[1024];
		int len;
		while ((len = input.read(buffer)) > 0 && isRun) {
			access.write(buffer, 0, len);
		}
		System.out.println("下载完成");
	}

	class MyThread extends Thread {
		int part;

		public MyThread(int part) {
			this.part = part;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			try {
				test2(part);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
