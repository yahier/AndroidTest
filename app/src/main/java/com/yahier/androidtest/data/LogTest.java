package com.yahier.androidtest.data;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.yahier.androidtest.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yahier on 17/1/22.
 */

public class LogTest extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_act);
        test();
        testPrint();
    }

    void test() {
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("test", "d");
                Log.i("test", "i");
                Log.e("test", "e");
            }
        }, 3000);
    }


    void testPrint() {
        try {
            Log.e("LogTest", "yahier before");
            Process process = Runtime.getRuntime().exec("logcat -d");
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(process.getInputStream()));

            Log.e("LogTest", "yahier");
            StringBuilder log = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                log.append(line).append("\n");
            }
            Log.e("yahierlog", log.toString());
            TextView tv = (TextView) findViewById(R.id.textView1);
            tv.setText(log.toString());
        } catch (IOException e) {

        }
    }
}