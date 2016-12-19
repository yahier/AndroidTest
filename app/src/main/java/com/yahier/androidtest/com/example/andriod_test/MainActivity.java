package com.yahier.androidtest.com.example.andriod_test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.yahier.androidtest.R;


import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView text;
	ShoucangDB db;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		text = (TextView) findViewById(R.id.text);

		db = new ShoucangDB(this);
		
		HandleAsync asyn = new HandleAsync();
		asyn.excute(new HandleAsync.Listener() {

			@Override
			public void parse(String result) {
				// TODO Auto-generated method stub
				// System.out.println("result is "+result);
				text.setText(result);
				Cursor cursor = db.query("2.0120101E7");
				cursor.moveToFirst();
				while (!cursor.isAfterLast()) {
					System.out.println("ũ��:"+cursor.getString(cursor.getColumnIndex(ShoucangDB.nongli)));
					System.out.println("�� :"+cursor.getString(cursor.getColumnIndex(ShoucangDB.yi)));
					
					cursor.moveToNext();
				}

			}

			@Override
			public String getResult() {
				// TODO Auto-generated method stub
				return "";
			}
		});

	}


}
