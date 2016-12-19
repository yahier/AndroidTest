package com.yahier.androidtest.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * 零件数据库，包括养护用品表，保养件，常见易损件
 * @author yahier
 *
 */
public class PartDB extends SQLiteOpenHelper {
	final static String db_name = "part.db";
	public final static String table1 = "keep_list";//养护用品表
	public final static String table2 = "keep_object";//保养件
	public final static String table3 = "common_bad";//常见易损
	
	//表1的字段
	public final static String table1_order_no = "order_no";// 序号
	public final static String table1_category = "part_category";// 类别
	public final static String table1_part_name = "part_name";// 备件名称
	public final static String table1_part_no= "part_no";// 备件编号
	public final static String table1_capacity = "part_capacity";// 容量
	public final static String table1_each_capacity = "each_car_capacity";// 单车用量
	public final static String table1_price_bottle = "price_bottle";// 元/瓶
	public final static String table1_price_time = "price_time";// 元/次
	public final static String table1_time = "work_time";// 工时数
	public final static String table1_pay = "work_price";// 工时价格
	public final static String table1_part_cattype = "part_car";// 备件车型

	//表2的字段
	public final static String table2_order_no = "order_no";// 序号
	public final static String table2_category = "part_category";// 类别
	public final static String table2_group = "part_group";// 组别
	public final static String table2_part_no= "part_no";// 备件编号
	public final static String table2_part_name = "part_name";//备件名称
	public final static String table2_user_price = "user_price";// 用户价
	public final static String table2_time = "work_time";// 工时数
	public final static String table2_pay = "work_price";// 工时价格
	public final static String table2_part_cattype = "part_car";// 备件车型
	
	//表2的字段
	public final static String table3_order_no = "order_no";// 序号
	public final static String table3_category = "part_category";// 类别
	public final static String table3_group = "part_group";// 组别
	public final static String table3_part_name = "part_name";//备件名称
	public final static String table3_part_no= "part_no";// 备件编号
	public final static String table3_user_price = "user_price";// 用户价
	public final static String table3_time = "work_time";// 工时数
	public final static String table3_pay = "work_price";// 工时价格
	public final static String table3_part_cattype = "part_car";// 备件车型
	

	public PartDB(Context context) {
		super(context, db_name, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		//建立第一张表
		String sql1 = "CREATE TABLE " + table1
				+ "(_id INTEGER primary key autoincrement," 
				+ table1_order_no+ " text," 
				+ table1_category + " text," 
				+ table1_part_name+ " text," 
				+ table1_part_no + " text," 
				+ table1_capacity+ " text," 
				+ table1_each_capacity + " text," 
				+ table1_price_bottle+ " text," 
				+ table1_price_time + " text," 
				+ table1_time+ " text," 
				+ table1_pay + " text," 
				+ table1_part_cattype + " text)";
		
		db.execSQL(sql1);
		System.out.println("s1 is " + sql1);
		
		//建立第二张表
		String sql2 = "CREATE TABLE " + table2
				+ "(_id INTEGER primary key autoincrement," 
				+ table2_order_no+ " text," 
				+ table2_category + " text," 
				+ table2_group+ " text," 
				+ table2_part_no + " text," 
				+ table2_part_name+ " text," 
				+ table2_user_price + " text," 
				+ table2_time+ " text," 
				+ table2_pay + " text," 
				+ table2_part_cattype + " text)";
		
		db.execSQL(sql2);
		System.out.println("s2 is " + sql2);
		
		//建立第三张表
		String sql3 = "CREATE TABLE " + table3
				+ "(_id INTEGER primary key autoincrement," 
				+ table3_order_no+ " text," 
				+ table3_category + " text," 
				+ table3_group+ " text," 
				+ table3_part_name + " text," 
				+ table3_part_no+ " text," 
				+ table3_user_price + " text," 
				+ table3_time+ " text," 
				+ table3_pay + " text," 
				+ table3_part_cattype + " text)";
		
		db.execSQL(sql3);
		System.out.println("s3 is " + sql3);
		

	}
	/**
	 * 给表一 ，也就是养护用品清单表 写入数据
	 * @param str
	 */
	public void insertToTable1(String... str) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
        cv.put(table1_capacity, 100);    
		db.insert(table1, null, cv);
	}
	
	/**
	 * 给表一 ，也就是保养件表 写入数据
	 * @param str
	 */
	public void insertToTable2(String... str) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
        cv.put(table1_capacity, 100);    
		db.insert(table2, null, cv);
	}
	
	/**
	 * 给表三 ，也就是 常用易损物件表 写入数据
	 * @param str
	 */
	public void insertToTable3(String... str) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues cv = new ContentValues();
        cv.put(table1_capacity, 100);    
		db.insert(table3, null, cv);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}
	
	

}
