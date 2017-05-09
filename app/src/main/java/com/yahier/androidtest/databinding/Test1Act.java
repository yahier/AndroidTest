package com.yahier.androidtest.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yahier.androidtest.BR;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/5/9.
 */

public class Test1Act extends AppCompatActivity {
    com.yahier.androidtest.databinding.DatabindingTest1Binding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.databinding_test1);

        test1();
        test2();
    }


    void test1(){
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                binding.mainTv1.setText("你好啊 test1方法");
            }
        },1000);

    }

    void test2(){
        User user = new User("绑定Model数据类型");
        binding.setUser(user);
        binding.setContent("从test2设置了yahier");
    }
}
