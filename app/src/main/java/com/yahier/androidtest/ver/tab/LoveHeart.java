package com.yahier.androidtest.ver.tab;



import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.yahier.androidtest.R;

/**
 * 
 * @description
 * @author 古阿古斯
 * @date 2013-4-27
 * @version
 */
public class LoveHeart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.love_heart);
		((TextView) findViewById(R.id.text)).setText("heart");
	}

}
