package com.yahier.androidtest.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/5/9.
 * 测试 事件绑定。还存在问题 View事件传递不了。
 */

public class Test2Act extends AppCompatActivity {
    com.yahier.androidtest.databinding.DatabindingTest2Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.databinding_test2);

        test1();
        test2();

    }


    void test1() {
        binding.setTitle1("事件绑定1");
        binding.setTitle2("事件绑定2");
        binding.setTitle3("事件绑定3");
        binding.setTitle4("change ok");
    }


    void test2() {
        binding.setEvent(new EventListener() {
            @Override
            public void click1(View v) {
                binding.setTitle1("事件1方法调用");
            }

            @Override
            public void click2(View v) {
                binding.setTitle2("事件2方法调用");
            }

            @Override
            public void cilck3(String s) {
                binding.setTitle3(s);
            }
        });
    }

}
