package com.yahier.androidtest.multipleThreads;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.R;
import com.yahier.androidtest.service.MyIntentService;

/**
 * Created by yahier on 17/2/10.
 */

public class TestIntentServiceAct extends Activity implements View.OnClickListener {

    String tag = "TestIntentServiceAct";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);
        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setText("startService");
        btn1.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                Log.e("TestIntentServiceAct", "click btn1 threadId:" + Thread.currentThread().getId());
                startService(new Intent(this, MyIntentService.class));
                break;
            case R.id.btn2:
                break;
        }
    }


    void sleep5000() {
        Log.e(tag, "sleep之前 threadId:"+Thread.currentThread().getId());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e(tag, "sleep之后");
    }
}
