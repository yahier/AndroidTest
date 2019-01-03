package com.yahier.androidtest.service;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/1/5.
 */

public class AccessServiceAct extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qhb);

        Intent intent = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(intent);
    }

    public void start(View v) {
        if (MyAccessibilityService.ALL) {
            MyAccessibilityService.ALL = false;
            ((Button) v).setText("对话内监控+关");
        } else {
            MyAccessibilityService.ALL = true;
            ((Button) v).setText("对话内监控+开");
        }
        ;

    }
}
