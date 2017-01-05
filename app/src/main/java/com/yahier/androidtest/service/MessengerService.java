package com.yahier.androidtest.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

public class MessengerService extends Service {
	/** 用于Handler里的消息类型 */
	static final int MSG_SAY_HELLO = 1;

	/**
	 * 在Service处理Activity传过来消息的Handler
	 */
	class IncomingHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case MSG_SAY_HELLO:
				Toast.makeText(getApplicationContext(), "hello!",Toast.LENGTH_SHORT).show();
				break;
			default:
				super.handleMessage(msg);
			}
		}
	}

	/**
	 * 这个Messenger可以关联到Service里的Handler，Activity用这个对象发送Message给Service，
	 * Service通过Handler进行处理。
	 */
	final Messenger mMessenger = new Messenger(new IncomingHandler());

	/**
	 * 当Activity绑定Service的时候，通过这个方法返回一个IBinder，Activity用这个IBinder创建出的Messenger，
	 * 就可以与Service的Handler进行通信了
	 */
	@Override
	public IBinder onBind(Intent intent) {
		Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT)
				.show();
		return mMessenger.getBinder();
	}
}