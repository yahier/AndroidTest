package com.yahier.androidtest.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/5/9.
 * 通过静态方法转换数据类型
 - 通过运算符操作数据
 */

public class Test3Act extends BaseActivity {
    com.yahier.androidtest.databinding.DatabindingTest3Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.databinding_test3);

        binding.setUser(new User("我在test3中被设置"));
    }
}
