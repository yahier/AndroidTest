package com.yahier.androidtest.util;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yahier.androidtest.R;
import com.yahier.androidtest.util.apache.beanutils.BeanUtilsTest;
import com.yahier.androidtest.util.apache.collection.CollectionsTest;

/**
 * Created by yahier on 10/1/18.
 */

public class ApacheCommonTestAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_apache_common);

        findViewById(R.id.btn1).setOnClickListener(v -> {
            CollectionsTest.test1();
        });

        findViewById(R.id.btn2).setOnClickListener(v -> {
            BeanUtilsTest.test1();
        });


    }
}
