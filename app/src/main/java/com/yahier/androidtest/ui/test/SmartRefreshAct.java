package com.yahier.androidtest.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.api.RefreshLayout;
import com.scwang.smart.refresh.layout.listener.OnLoadMoreListener;
import com.scwang.smart.refresh.layout.listener.OnRefreshListener;
import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.adapter.MainRecycleAdapter;
import com.yahier.androidtest.metarial.MainItem;
import com.yahier.androidtest.view.act.CommonViewTest;

/**
 *
 */
public class SmartRefreshAct extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_smartrefreshlayout);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MainItem[] itemArray = new MainItem[6];
        for (int i = 0; i < 6; i++) {
            MainItem item = new MainItem("哈哈" + i, CommonViewTest.class);
            itemArray[i] = item;
        }
        final com.yahier.androidtest.adapter.MainRecycleAdapter mAdapter = new MainRecycleAdapter(itemArray);
        recyclerView.setAdapter(mAdapter);

        SmartRefreshLayout refreshLayout = findViewById(R.id.freshLayout);
        refreshLayout.setRefreshHeader(new ClassicsHeader(this));
        refreshLayout.setRefreshFooter(new ClassicsFooter(this));
        refreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败

                //refreshlayout.finishLoadMoreWithNoMoreData();
            }
        });

        refreshLayout.finishLoadMoreWithNoMoreData();
        refreshLayout.setEnableFooterFollowWhenNoMoreData(true);
    }
}
