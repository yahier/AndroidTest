package com.yahier.androidtest.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/5/9.
 * 相同类名，不同映射。有待继续测试
 */

public class Test4Act extends AppCompatActivity {
    com.yahier.androidtest.databinding.DatabindingTest4Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.databinding_test4);


        User user3  = new User("相同类，不同对象1");
        binding.setUser3(user3);

        User user4 = new User("相同类，不同对象2");
        binding.setUser4(user4);

    }
}
