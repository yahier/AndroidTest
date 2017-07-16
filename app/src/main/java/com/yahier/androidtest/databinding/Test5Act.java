package com.yahier.androidtest.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yahier.androidtest.R;

import java.util.Random;

/**
 * Created by yahier on 17/5/9.
 */

public class Test5Act extends AppCompatActivity {
    com.yahier.androidtest.databinding.DatabindingTest5Binding binding;
    Person person;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.databinding_test5);

        test1();
        test2();
    }

    void test1() {
        person = new Person("zhang", "san", 38);
        binding.setPerson(person);
    }

    void test2() {
        binding.secondBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                person.setFirstName("li");
                person.setLastName("si");
                int age = new Random().nextInt(80);
                person.setAge(age);
            }
        });
    }
}
