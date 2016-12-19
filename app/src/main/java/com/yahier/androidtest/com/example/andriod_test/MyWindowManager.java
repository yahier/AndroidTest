package com.yahier.androidtest.com.example.andriod_test;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.yahier.androidtest.R;

public class MyWindowManager extends Activity {
	private WindowManager mWindowManager;
	private WindowManager.LayoutParams params;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.window);
		Button button = (Button) findViewById(R.id.button_window);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				showWindow();
			}
		});

	}

	void showWindow() {
		final TextView text = new TextView(this);
		text.setText("yahier");
		mWindowManager=(WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
		params = new WindowManager.LayoutParams(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
		params.flags=WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		//params.flags=params.flags|WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
		params.width = 200;
		params.height = 100;
		mWindowManager.addView(text, params);
		
		text.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mWindowManager.removeView(text);
			}
		});
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
}
