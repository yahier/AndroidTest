package com.yahier.androidtest.service;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/1/5.
 */

public class AccessServiceAct extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);
        Button btn = (Button)findViewById(R.id.btn1);
        btn.setText("启动AccessbilityService");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //android.accessibilityservice.AccessibilityService
                Intent intent = new Intent("android.accessibilityservice.AccessibilityService");
                startActivity(intent);
            }
        });
    }
}
