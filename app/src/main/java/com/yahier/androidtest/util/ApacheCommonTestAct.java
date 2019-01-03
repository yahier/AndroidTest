package com.yahier.androidtest.util;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.util.apache.BeanUtilsTest;
import com.yahier.androidtest.util.apache.CollectionsTest;
import com.yahier.androidtest.util.apache.IOTest;
import com.yahier.androidtest.util.apache.LangTest;

/**
 * Created by yahier on 10/1/18.
 */

public class ApacheCommonTestAct extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apache_common);

        String[] permissions = {Manifest.permission.INTERNET};
        ActivityCompat.requestPermissions(this, permissions, 99);

        findViewById(R.id.btn1).setOnClickListener(v -> {
            CollectionsTest.main();
        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
            BeanUtilsTest.test1();
        });

        findViewById(R.id.btn3).setOnClickListener(v -> {
            IOTest.main(ApacheCommonTestAct.this);
        });

        findViewById(R.id.btn4).setOnClickListener(v -> {
            LangTest.main();
        });

    }
}
