package com.yahier.androidtest.com.example.andriod_test;

import java.io.File;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

import com.yahier.androidtest.R;

public class May526 extends Activity {
	TextView text;
	private static final String LOG_TAG = "ScreenCapReceiver";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.may521);
		text = (TextView) findViewById(R.id.text);
		String value;
		if (savedInstanceState == null) {
			value = "null";
		} else {
			value = savedInstanceState.getString("y");
		}

		text.setText("526" + value);

	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("y", "yahier");

	}

}
