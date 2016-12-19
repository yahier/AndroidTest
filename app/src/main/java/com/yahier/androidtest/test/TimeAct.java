package com.yahier.androidtest.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.yahier.androidtest.R;


public class TimeAct extends Activity {

	int count = 0;
	int min = 0, second = 0;
	TextView time;
	public static boolean state = true;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.time);

		time = (TextView) findViewById(R.id.time);
		handler.sendEmptyMessageAtTime(0, 1000);

	}

	Handler handler = new Handler(new Handler.Callback() {

		@Override
		public boolean handleMessage(Message msg) {

			handler.sendEmptyMessageDelayed(0, 1000);
			min = count / 60;
			second = count % 60;
			String min_str, second_str;
			if (min < 10)
				min_str = "0" + min;
			else
				min_str = "" + min;

			if (second < 10)
				second_str = "0" + second;
			else
				second_str = "" + second;
			
			time.setText(min_str + ":" + second_str);
			count++;

			return false;
		}
	});

}