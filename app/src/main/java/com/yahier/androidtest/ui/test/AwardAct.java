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
            if (offSize > 0) {
                stopCycle();
            } else {
                pick100LuckyGuys();
                cycle100();
            }
        });
    }


    /**
     * 抽取100个中奖名单
     */
    private void pick100LuckyGuys() {
        offSize = 0;
        List<People> list = DataManager.getList(100, offSize);
        mAdapter.setData(list);
        recyclerView.setAdapter(mAdapter);
    }

    Runnable runnable100 = new Runnable() {
        @Override
        public void run() {
            List<People> list = DataManager.getList(100, offSize);
            mAdapter.setData(list);
            cycle100();
        }
    };

    private volatile int offSize = 0;

    private void cycle100() {
        if (offSize >= 0) {
            recyclerView.postDelayed(runnable100, 200);
        }
        offSize++;
    }

    @Override
    protected void onStop() {
        super.onStop();
        stopCycle();
    }

    private void stopCycle() {
        recyclerView.removeCallbacks(runnable100);
        offSize = -2;
    }
}
