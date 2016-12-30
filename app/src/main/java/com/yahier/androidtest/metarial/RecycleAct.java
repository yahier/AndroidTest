package com.yahier.androidtest.metarial;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yahier.androidtest.MyAdapter;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 16/12/30.
 */

public class RecycleAct extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_recycle);
        initRecycleView();
    }


    void initRecycleView() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        int size = 25;
        String[] myDataset = new String[size];
        for (int i = 0; i < size; i++) {
            myDataset[i] = "人民广场" + i + "绝世好剑";
        }
        MyAdapter mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
    }
}
