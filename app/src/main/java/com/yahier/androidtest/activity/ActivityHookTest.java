package com.yahier.androidtest.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.test.HookHelper;

public class ActivityHookTest extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);

        Button btn1 = (Button) findViewById(R.id.btn1);
        btn1.setText("hook启动没有注册的Activity");
        btn1.setOnClickListener(v -> startAct());

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setText("hook启动没有注册的Activity");
        btn2.setOnClickListener(v -> startByAMS());
    }

    void startAct() {
        try {
            HookHelper.replaceInstrumentation(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
        startActivity(new Intent(this, EventActivity.class));
    }

    void startByAMS() {
        try {
            HookHelper.hookAMS();
        } catch (Exception e) {
            e.printStackTrace();
        }
        startActivity(new Intent(this, EventActivity.class));
    }
}
