package com.yahier.androidtest.content.provider;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.yahier.androidtest.R;


public class TestCPActivity extends Activity implements OnClickListener {
	EditText input;
	TextView textShow;
	Uri uri;
	ContentResolver cr;
	final String myUri ="content://com.yahier/"+YahierDBHelper.tableName;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.content_provider_test);
		findViewById(R.id.insert).setOnClickListener(this);
		findViewById(R.id.query).setOnClickListener(this);
		textShow = (TextView) findViewById(R.id.text);
		input = (EditText) findViewById(R.id.input);
		uri = Uri.parse(myUri);
		cr = this.getContentResolver();
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.insert:
			if(input.getText().toString().equals("")){
				return;
			}
			ContentValues values = new ContentValues();
			values.put("name", input.getText().toString());
			cr.insert(uri, values);
			break;
		case R.id.query:
			Cursor c = cr.query(uri, null, null, null, null);
			if(c==null){
				Toast.makeText(this, "cursor is null", 2000).show();
				return;
			}
			textShow.setText("");
			c.moveToFirst();
			while (c.moveToNext()) {
				textShow.append(c.getString(1) + "\r\n");
			}
			break;
		}

	}

}
