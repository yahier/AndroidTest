package com.yahier.androidtest.viewtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/1/3.
 */

public class SwipeRefreshLayoutTest extends Activity {
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.swiperefresh_test);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Log.e("SwipeRefreshLayoutTest", "onRefresh");


                getWindow().getDecorView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipe.setRefreshing(false);

                    }
                }, 2000);
            }
        });


    }


}
