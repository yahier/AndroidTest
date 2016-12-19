package com.yahier.androidtest.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 常见问题数据库表
 * @author yahier
 *
 */
public class CommonProblemsDB extends SQLiteOpenHelper {
	final static String db_name = "common_problem.db";
	public final static String table1 = "common_problem";//常见故障问题表
	
	public final static String position = "position";// 部位
	public final static String order_no = "order_np";// 序号
	public final static String des = "des";// 故障描述
	

	public CommonProblemsDB(Context context) {
		super(context, db_name, null, 1);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String s = "CREATE TABLE " + table1
				+ "(_id INTEGER primary key autoincrement," 
				+ position+ " text," 
				+ order_no + " text," 
				+ des + " text)";

		System.out.println("s is " + s);
		db.execSQL(s);

	}
	/**
	 * 给常见问题表插入数据
	 * @param str
	 */
	public void insert(String... str) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
		cv.put(this.position, str[0]);
		cv.put(this.order_no, str[1]);
		cv.put(this.des, str[2]);
		db.insert(table1, null, cv);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	

}
