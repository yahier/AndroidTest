package com.yahier.androidtest.com.example.andriod_test;


import com.yahier.androidtest.R;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    TextView text;
    ShoucangDB db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView) findViewById(R.id.text);

        db = new ShoucangDB(this);


//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                Log.e("run","finish");
//                finish();
//
//
//            }
//        }, 5000);

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent intent = new Intent(view.getContext(), LoveAsk.class);
               // startActivity(intent);
            }
        });
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        getWindow().getDecorView().postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                finish();
//
//
//            }
//        }, 3000);
//    }

    //mContext周期到底有多长。
    void test1() {
        final int a = 1;
        final Context mContxt = MainActivity.this;
        HandleAsync asyn = new HandleAsync();
        asyn.excute(new HandleAsync.Listener() {

            @Override
            public void parse(String result) {
                Log.e("act", "parse");
                Context appContext = mContxt.getApplicationContext();
                appContext.toString();
                Log.e("act", "a:" + a);


                final Context mContxt2 = MainActivity.this;
                Context appContext2 = mContxt2.getApplicationContext();
            }

            @Override
            public String getResult() {
                Log.e("act", "getResult");
                try {
                    Thread.sleep(50000);
                } catch (Exception e) {
                    //pass
                }
                return "";
            }
        });
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e("act", "onStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("act", "onDestroy");
    }
}
