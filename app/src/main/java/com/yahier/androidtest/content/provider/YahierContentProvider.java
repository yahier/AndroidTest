package com.yahier.androidtest.content.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class YahierContentProvider extends ContentProvider {
	private YahierDBHelper dbHelper;
	private static final UriMatcher sUriMatcher;
	private static final int common =1;
	private static final int DIARIES = 2;

	public final static String AUTHORITY = "com.yahier";
	static {
		sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		sUriMatcher.addURI(AUTHORITY, YahierDBHelper.tableName,common);
		sUriMatcher.addURI(AUTHORITY+"/Diaries", YahierDBHelper.tableName, DIARIES);
		
	}

	@Override
	public int delete(Uri arg0, String arg1, String[] arg2) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		int id = db.delete(YahierDBHelper.tableName, arg1, arg2);
		if (id != 0)
			return id;
		return 0;
	}

	@Override
	public String getType(Uri arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Uri insert(Uri arg0, ContentValues values) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		db.insert(YahierDBHelper.tableName, "id", values);
		return null;
	}

	@Override
	public boolean onCreate() {
		dbHelper = new YahierDBHelper(this.getContext());
		dbHelper.open();

		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		System.out.println("查询来了:"+uri);
		System.out.println("match:"+sUriMatcher.match(uri));
		Cursor c = null;
		switch (sUriMatcher.match(uri)) {
		
		case common:
			SQLiteDatabase db = dbHelper.getWritableDatabase();
			c = db.query(YahierDBHelper.tableName, projection, selection, selectionArgs, null, null, sortOrder);
			break;
		// default:
		// throw new IllegalAccessException("unknown uri");
		}
		return c;
	}

	@Override
	public int update(Uri arg0, ContentValues arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return 0;
	}

}
