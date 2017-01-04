package com.yahier.androidtest.content.provider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class YahierDBHelper extends SQLiteOpenHelper {
	public final static String tableName = "ya";
	
	public YahierDBHelper(Context context){
		super(context, tableName, null, 1);
	}

	public YahierDBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}
	
	public void open(){
		SQLiteDatabase db = getWritableDatabase();
		onOpen(db);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql = "create table ya (id INTEGER PRIMARY KEY AUTOINCREMENT,name varchar(10))";
		db.execSQL(sql);

	}

	
	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	public void insert(String name) {
		ContentValues value = new ContentValues();
		value.put("name", name);
		SQLiteDatabase db = getWritableDatabase();
		db.insert(tableName, null, value);
	}

	public void delete(String name) {
		String sql = "delete from ya where name = ?";
		SQLiteDatabase db = getWritableDatabase();
		db.delete(tableName, sql, new String[] { name });
	}

}
