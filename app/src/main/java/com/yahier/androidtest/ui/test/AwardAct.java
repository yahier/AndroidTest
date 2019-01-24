package com.yahier.androidtest.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

import java.util.List;

/**
 * Created by yahier on 1/22/19.
 * 抽取中奖名单
 */

public class AwardAct extends BaseActivity {
    RecyclerView recyclerView;
    MainRecycleAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_award);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(false);

        GridLayoutManager layoutManager = new GridLayoutManager(this, 5);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new MainRecycleAdapter();
        recyclerView.setAdapter(mAdapter);

        findViewById(R.id.btnAward100).setOnClickListener(v -> {
            if (keepWork) {
                stopCycle();
            } else {
                pick100LuckyGuys();
                cycle100();
            }
        });

        refreshSingleItem();
    }


    private void refreshSingleItem() {
        pick100LuckyGuys();
        recyclerView.postDelayed(() -> {
            mAdapter.refreshSingleItem(20, "知秋");
        }, 2000);
    }

    /**
     * 抽取100个中奖名单
     */
    private void pick100LuckyGuys() {
        keepWork = true;
        List<People> list = DataManager.getList(100);
        mAdapter.setData(list);
    }

    Runnable runnable100 = new Runnable() {
        @Override
        public void run() {
            List<People> list = DataManager.getList(100);
            mAdapter.setData(list);
            cycle100();
        }
    };

    private volatile boolean keepWork = false;

    private void cycle100() {
        if (keepWork) {
            recyclerView.postDelayed(runnable100, 200);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopCycle();
    }

    private void stopCycle() {
        recyclerView.removeCallbacks(runnable100);
        keepWork = false;
    }
}
