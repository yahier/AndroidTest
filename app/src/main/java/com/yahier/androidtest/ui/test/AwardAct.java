package com.yahier.androidtest.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.util.Yahier;
import com.yahier.androidtest.util.YahierEventManager;
import com.yahier.androidtest.vo.YahierEvent;

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
        YahierEventManager.getInstance().addAnnotation(this);
    }

    @Override
    protected void onStop() {
        YahierEventManager.getInstance().removeAnnotation(this);
        super.onStop();
        stopCycle();
    }


    /**
     * 注解的广播接收者 来自 YahierEvenetManager
     */
    @Yahier(type = 2)
    public void onYahierEvent(YahierEvent event) {
        Log.d("注解收到了广播", "type:" + event.getType());
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


    private void stopCycle() {
        recyclerView.removeCallbacks(runnable100);
        keepWork = false;
    }
}
