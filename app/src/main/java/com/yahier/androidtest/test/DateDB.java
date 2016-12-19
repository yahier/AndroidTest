package com.yahier.androidtest.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/** 存储 万年历的数据 */
public class DateDB extends SQLiteOpenHelper {
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

	public DateDB(Context context) {
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
		try {
			String where = xinli + " = ?";
			String[] whereValue = { xinliValue };
			SQLiteDatabase db = this.getReadableDatabase();
			return db.query(tableName, null, where, whereValue, null, null,null);
		} catch (SQLiteException e) {
			System.out.println("DataDB " + e.getMessage());
		}
		return null;
	}

	public void deleteRow(int id) {
		SQLiteDatabase db = this.getWritableDatabase();
		String where = "_id" + " = ?";
		String[] whereValue = { Integer.toString(id) };// id为删除列的id
		db.delete(tableName, where, whereValue);
		db.close();
	}

	/**
	 * 用作 吉日查询
	 * 
	 * @param startTime
	 *            开始时间 XXXXMMDD
	 * @param endTime
	 * @param yiji
	 *            宜或者忌
	 * @param type
	 *            类别:破土 安门 开市等等
	 * @return
	 */
	public Cursor query(int startTime, int endTime, String yiji, String type) {
		String sql = "select xinli,nongli from date where xinli>=" + startTime
				+ " and xinli<" + endTime;// " and yi like '%安门%'";
		String add = "";
		if (yiji.equals("宜")) {
			add = " and " + yi + " like '%" + type + "%'";
		} else if (yiji.equals("忌")) {
			add = " and " + ji + " like '%" + type + "%'";
		}

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql + add, null);
		return cursor;

	}

	/**
	 * 用作 查询周末
	 * 
	 * @param startTime
	 *            开始时间 XXXXMMDD
	 * @param endTime
	 * @param yiji
	 *            宜或者忌
	 * @param type
	 *            类别:破土 安门 开市等等
	 * @return
	 */
	public Cursor queryWeekend(int startTime, int endTime) {
		String sql = "select xinli from date where xinli>=" + startTime
				+ " and xinli<" + endTime
				+ " and (nongli like '%星期六%' or nongli like '%星期日%')";
		System.out.println("sql语句是     " + sql);
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(sql, null);
		return cursor;

	}
}
