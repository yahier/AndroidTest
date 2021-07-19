package com.yahier.androidtest.chart;

import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;


public class MainChartActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_chart2);
        initView();
    }


    void initView() {
        findViewById(R.id.tvLine).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(1);
            }
        });
        findViewById(R.id.tvBar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(2);
            }
        });
        findViewById(R.id.tvPie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFragment(4);
            }
        });
    }



    public void showFragment(int type) {
        FragmentManager fragmentManager = getFragmentManager();

        switch (type) {
            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new LineFragment())
                        .commit();
                break;
            case 2:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new BarFragment())
                        .commit();
                break;
//            case 3:
//                fragmentManager.beginTransaction()
//                        .replace(R.id.container, new ClockPieFragment())
//                        .commit();
//                break;
            case 4:
                fragmentManager.beginTransaction()
                        .replace(R.id.container, new PieFragment())
                        .commit();
        }

    }


}
