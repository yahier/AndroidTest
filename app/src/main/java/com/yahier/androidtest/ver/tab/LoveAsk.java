package com.yahier.androidtest.ver.tab;

import java.io.FileNotFoundException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Spinner;

import com.yahier.androidtest.R;

/**
 * 
 * @description
 * @author 古阿古斯
 * @date 2013-5-12
 * @version
 */
public class LoveAsk extends Activity {



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.love_heart);
		((TextView)findViewById(R.id.text)).setText("ask");
	}

}
