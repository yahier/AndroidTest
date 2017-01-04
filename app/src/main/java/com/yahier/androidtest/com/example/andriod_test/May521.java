package com.yahier.androidtest.com.example.andriod_test;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.yahier.androidtest.R;


/**
 * 测试回收
 */
public class May521 extends Activity {
	TextView text;
	private static final String LOG_TAG = "May521";

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

		findViewById(R.id.button).setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(May521.this, May526.class);
				startActivity(intent);

			}
		});

	}

	
	/**
	 */
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		outState.putString("y", "yahier");

	}

}
