package com.yahier.androidtest.metarial;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yahier.androidtest.MyAdapter;
import com.yahier.androidtest.R;

import java.util.ArrayList;
import java.util.List;

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

    RecyclerView mRecyclerView;

    void initRecycleView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);


        final String[] myDataset = {"我不知道玩什么这样", "动起来", "为新的力量喝彩", "每一秒都期待", "东周列国志", "左转 周天子啊", "战国后期,秦国愈加强大,其它为了过了对抗秦国,", "开始用各种手段网络天下人才", "食客或者门客开始兴起", "后世开始有记录战国四公子的事情了", "信陵君窃符救赵,春申君", "曾一起走过的日子"};
        final MyAdapter mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                deleteHead(myDataset);
                mAdapter.notifyDataSetChanged();
            }
        }, 4000);
    }

    void deleteHead(String[] myDataset) {
        for (int i = 0; i < myDataset.length - 1; i++) {
            myDataset[i] = myDataset[i + 1];
        }
        myDataset[myDataset.length - 1] = null;
    }


}
