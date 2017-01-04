package com.yahier.androidtest.download;

import java.io.IOException;


import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.yahier.androidtest.R;


/**
 * 测试断点续传. 百分比显示。暂停。停止。断点续传。
 * 
 * @author yahier.
 * 
 */

public class DownTest extends Activity {
	static TextView text;
	static Context mContext;
	static boolean flag = true;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.down);
		text = (TextView) findViewById(R.id.text);
		mContext = this;
		findViewById(R.id.start).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				System.out.println("开始");
				// 第二种方法。4.6s
				FileDownloader load = new FileDownloader();
			    load.down();

				// 第一种方法 9.8s

	/*			if (flag == false) {
					flag = true;
					return;
				}

				try {
					FileUtil.write(handler);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});

		findViewById(R.id.pause).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				flag = false;
				System.out.println("暂停。。。");

			}
		});

		findViewById(R.id.stop).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

			}
		});
	}

	Handler handler = new Handler() {
		public void handleMessage(Message msg) {

			Size size = (Size) msg.obj;
			float progress = size.getCurrent() / size.getAll() * 100;
			String float_str = String.valueOf(progress);
			int index = float_str.indexOf(".");
			if (index > 0)
				text.setText("进度是:" + float_str.substring(0, index) + "%");
			else
				text.setText("进度是:" + float_str + "%");
		}
	};

}
