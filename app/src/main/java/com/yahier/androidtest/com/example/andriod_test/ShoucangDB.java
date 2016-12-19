package com.yahier.androidtest.com.example.andriod_test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/** 保存的职位搜索记录职位搜�? */
public class ShoucangDB extends SQLiteOpenHelper {
	final static String db_name = "wan.db";
	final String tableName = "date";
	public final static String xinli = "xinli";
	public final static String nongli = "nongli";
	public final static String ganzhi = "ganzhi";
	public final static String yi = "yi";

	public final static String ji = "ji";
	public final static String jishen = "jishen";
	public final static String xiongshen = "xiongshen";
	public final static String taishen = "taishen";

	public final static String wuxing = "wuxing";
	public final static String chong = "chong";
	public final static String baiji = "baiji";

	public ShoucangDB(Context context) {
		super(context, db_name, null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String s = "CREATE TABLE " + tableName
				+ "(_id INTEGER primary key autoincrement," + xinli + " text,"
				+ nongli + " text," + ganzhi + " text," + yi + " text," + ji
				+ " text," + jishen + " text," + xiongshen + " text," + taishen
				+ " text," + wuxing + " text," + chong + " text," + baiji
				+ " text)";
		System.out.println("s is " + s);
		db.execSQL(s);
		System.out.println("onCreate");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	public void insert(String... str) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(this.xinli, str[0]);
		cv.put(this.nongli, str[1]);
		cv.put(this.ganzhi, str[2]);
		cv.put(this.yi, str[3]);

		cv.put(this.ji, str[4]);
		cv.put(this.jishen, str[5]);
		cv.put(this.xiongshen, str[6]);
		cv.put(this.taishen, str[7]);

		cv.put(this.wuxing, str[8]);
		cv.put(this.chong, str[9]);
		cv.put(this.baiji, str[10]);

		db.insert(tableName, null, cv);
		
	}

	public Cursor query(String xinliValue) {

		String where = xinli + " = ?";
		String[] whereValue = { xinliValue };// idΪɾ���е�id
		SQLiteDatabase db = this.getReadableDatabase();
		return db.query(tableName, null, where, whereValue, null, null, null);
	}

	public void deleteRow(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		String where = "_id" + " = ?";
		String[] whereValue = { Integer.toString(id) };// id为删除列的id
		db.delete(tableName, where, whereValue);
		db.close();
	}
}
