package com.yahier.androidtest.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/5/9.
 * 绑定容器 泛型 失败。
 */

public class Test6Act extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBindingUtil.setContentView(this, R.layout.databinding_test6);
    }
}
