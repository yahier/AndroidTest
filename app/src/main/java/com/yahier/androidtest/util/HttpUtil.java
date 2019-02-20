package com.yahier.androidtest.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class HttpUtil {
    private final static String TAG = "HttpUtil";
    private static HttpURLConnection conn = null;

    public static String invoke(String urlPath) {
        HashMap<String, String> paras = new HashMap<String, String>();
        paras.put("departments", "4");

        try {
            InputStream in = sendPOSTRequestForInputStream(urlPath, paras);
            String content = getData(in);
            return content;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    static String getData(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        try {
            String content = reader.readLine();
            Log.d(TAG, "content:" + content);
            return content;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    private static InputStream sendPOSTRequestForInputStream(String path, HashMap<String, String> params) throws Exception {
        StringBuilder entityBuilder = new StringBuilder("");
        byte[] entity = entityBuilder.toString().getBytes();
        URL url = new URL(path);
        conn = (HttpURLConnection) url.openConnection();

        conn.setConnectTimeout(5 * 1000);
        //conn.setRequestMethod("POST");
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        conn.setRequestProperty("Content-Length", String.valueOf(entity.length));
        OutputStream outStream = conn.getOutputStream();
        outStream.write(entity);
        outStream.flush();
        outStream.close();
        return conn.getInputStream();
    }
}
