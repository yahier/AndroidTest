package com.yahier.androidtest.slide.circle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.yahier.androidtest.R;


/**
 * 测试圆环   是
 */

public class Circle extends Activity {
	private ImageView point;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		System.out.println("time is " + System.currentTimeMillis());
		setContentView(R.layout.circle);
		point = (ImageView) findViewById(R.id.point);

		point.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.out.println();
			}
		});

	}

}
