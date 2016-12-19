package com.yahier.androidtest.test;

import java.io.File;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.yahier.androidtest.R;
import com.yahier.androidtest.data.CommonProblemsDB;
import com.yahier.androidtest.data.HandleAsync;
import com.yahier.androidtest.data.PartDB;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import static android.R.attr.data;

public class ParseXLS extends Activity {

	CommonProblemsDB db;
	PartDB part_db;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.parse);

		db = new CommonProblemsDB(this);
		part_db=new PartDB(this);

		Button start = (Button) findViewById(R.id.parse_start);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startParse(FileUtil.common_problems);
			}
		});
	}

	void startParse(String filePath) {
		FileUtil.copyToSdcard(this, filePath);
		 readXLS(filePath);
	}

	public void readXLS(final String path) {
		HandleAsync hand = new HandleAsync();
		hand.excute(new HandleAsync.Listener() {

			@Override
			public void parse(String result) {
				// TODO Auto-generated method stub

			}

			@Override
			public String getResult() {
				// TODO Auto-generated method stub
				make(path);
				return "";
			}
		});

	}

	String make(String path){
		String resulMsg = "";
		try {
			Workbook workbook = null;
			workbook = Workbook.getWorkbook(new File(path));
			Sheet sheet = workbook.getSheet(0);
			Cell cell = null;
			int columnCount = sheet.getColumns();// 3
			int rowCount = sheet.getRows();// 95
			System.out.println("columnCount is  "+columnCount+"  rowCount is "+rowCount);
			for (int i = 1; i < rowCount; i++) {
				String[] datas = new String[11];
				for (int j = 0; j < columnCount; j++) {
					cell = sheet.getCell(j, i);
					String temp2  = "" + cell.getContents();
					datas[j] = temp2;
				}
				db.insert(datas[0],datas[1],datas[2]);
			}

			part_db.insertToTable1("");
			System.out.println("Main  日期数据 写入数据库 完成");
			db.close();
			workbook.close();
			resulMsg = "成功";
		} catch (Exception e) {
			System.out.println("解析异常 e is " + e.getMessage());
			resulMsg = null;
		}

		return resulMsg;
	}
}