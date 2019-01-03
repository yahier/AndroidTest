package com.yahier.androidtest.databinding;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableArrayList;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/5/9.
 * 绑定容器 泛型 失败。
 */
@Route(path = "/databinding/Test6Act")
public class Test6Act extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabindingTest6Binding binding = DataBindingUtil.setContentView(this, R.layout.databinding_test6);

        ObservableArrayList users = new ObservableArrayList();
        users.add(new UserObservable("George", "Mount"));
        binding.setUsers(users);
    }
}
