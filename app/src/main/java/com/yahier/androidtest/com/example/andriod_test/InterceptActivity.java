package com.yahier.androidtest.com.example.andriod_test;

import android.app.Activity;
import android.content.ContentValues;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import com.yahier.androidtest.R;

/**
 * 拦截短信什么的
 * @author yahier
 *
 */
public class InterceptActivity extends Activity {
	class SmsContent extends ContentObserver {
		private Cursor cursor = null;

		public SmsContent(Handler handler) {
			super(handler);
		}

		/**
		 * @Description 当短信表发送改变时，调用该方法 需要两种权限 android.permission.READ_SMS读取短信
		 *              android.permission.WRITE_SMS写短信
		 * @Author
		 * @Date
		 */
		@Override
		public void onChange(boolean selfChange) {
			// TODO Auto-generated method stub
			super.onChange(selfChange);
			// 读取收件箱中指定号码的短信
			cursor = managedQuery(Uri.parse("content://sms/inbox"),
					new String[] { "_id", "address", "read" },
					" address=? and read=?",
					new String[] { "12345678901", "0" }, "date desc");

			if (cursor != null) {
				ContentValues values = new ContentValues();
				values.put("read", "1"); // 修改短信为已读模式
				cursor.moveToFirst();
				while (cursor.isLast()) {
					// 更新当前未读短信状态为已读
					getContentResolver().update(
							Uri.parse("content://sms/inbox"), values, " _id=?",
							new String[] { "" + cursor.getInt(0) });
					cursor.moveToNext();
				}
			}
		}
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		SmsContent content = new SmsContent(new Handler());
		// 注册短信变化监听
		this.getContentResolver().registerContentObserver(Uri.parse("content://sms/"), true, content);
	}

}
