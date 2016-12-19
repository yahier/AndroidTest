package com.yahier.androidtest.ver.tab;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
public class LoveHelp extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.love_heart);
		((TextView)findViewById(R.id.text)).setText("help");

	}

}
