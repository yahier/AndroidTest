package com.yahier.androidtest.util;

import android.os.AsyncTask;

/**
 * Created by yahier on 1/29/19.
 */

public class HandlerAsync {

    public void execute(HandlerAsync.Listener dealListener) {
        new MyAsync(dealListener).execute();
    }

    class MyAsync extends AsyncTask<Void, Void, String> {
        Listener listener;

        public MyAsync(Listener listener) {
            this.listener = listener;
        }

        @Override
        protected String doInBackground(Void... parse) {
            return listener.getResult();
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            listener.parse(result);
        }
    }

    public interface Listener {
        /**
         * 获取接口的数据
         *
         * @return
         */
        String getResult();

        /**
         * 解析得到的数据
         *
         * @param result
         */
        void parse(String result);
    }
}