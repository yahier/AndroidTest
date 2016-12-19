package com.yahier.androidtest.com.example.andriod_test;

import android.os.AsyncTask;

/**
 * 封装异步任务类的操作
 * @author 子旺
 *
 */
public class HandleAsync {

	public void excute(Listener dealListener) {
		new MyAsync(dealListener).execute();
	}

	class MyAsync extends AsyncTask<Void, Void, String> {
		Listener listener;

		public MyAsync(Listener listener) {
			this.listener = listener;
		}

		@Override
		protected String doInBackground(Void... parse) {
			String result = listener.getResult();
			return result;
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);
			listener.parse(result);

		}

	}

	public interface Listener {
		/**
		 * 获取接口的数�?
		 * @return
		 */
		String getResult();

		/**
		 * 解析得到的数�?
		 * @param result
		 */
		void parse(String result);
	}
}
