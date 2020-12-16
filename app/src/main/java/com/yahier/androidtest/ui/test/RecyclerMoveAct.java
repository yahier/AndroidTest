package com.yahier.androidtest.ui.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.adapter.MoveAdapter;
import com.yahier.androidtest.util.move_hepler.OnStartDragListener;
import com.yahier.androidtest.util.move_hepler.SimpleItemTouchHelperCallback;
import com.yahier.androidtest.vo.CommonItem;

import java.util.Arrays;
import java.util.List;

/**
 * recyclerView拖动测试
 */
public class RecyclerMoveAct extends BaseActivity implements OnStartDragListener {
    ItemTouchHelper mItemTouchHelper;
    MoveAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_recycler_move);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> listOrigin = Arrays.asList("冷雨夜", "光辉岁月", "无尽的轨迹", "长空", "你知道我的迷惘");
        List<CommonItem> listData = CommonItem.getNormalList(listOrigin);
        adapter = new MoveAdapter(listData);
        adapter.setOnStartDragListener(this);
        recyclerView.setAdapter(adapter);

        initDrag();

        findViewById(R.id.btnAdd).setOnClickListener(v -> {
            List<String> listTemp = Arrays.asList("1111", "22222", "333333", "444444", "555555");
            List<CommonItem> listData2 = CommonItem.getNormalList(listTemp);
            listData2.add(CommonItem.getMark("口袋3"));
            adapter.addListData(listData2);
        });
    }


    private void initDrag() {
        //初始化拖动
        SimpleItemTouchHelperCallback callback = new SimpleItemTouchHelperCallback(adapter);
        mItemTouchHelper = new ItemTouchHelper(callback);
        mItemTouchHelper.attachToRecyclerView(recyclerView);
        callback.setOnDragListener(new SimpleItemTouchHelperCallback.OnDragListener() {
            @Override
            public void onDragFinished() {
                 //多余，不需要重写
//                List<CommonItem> list = adapter.getDataList();
//                for (CommonItem item : list) {
//                    Log.e("onDragFinished", item.name);
//                }
//                adapter.setListData(list);
            }

            @Override
            public void onChildDraw() {

            }

            @Override
            public void onSwap() {

            }


//            override fun onDragFinished() {
//                val adapterListData = recyclerAdapter.dataList
//                //判断 是否有移动
//                //要确保两个数组是不同的引用
//                for (index in 0 until listStrAll.size) {
//                    if (listStrAll[index] != adapterListData[index]) {
//                        val listTemp = ArrayList<String>()
//                        adapterListData.forEach {
//                            listTemp.add(it)
//                        }
//                        listStrAll = listTemp
//                        refreshAll()
//                        break
//                    }
//                }
//            }

        });
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        Log.e("口袋测试", "onStartDrag");
        mItemTouchHelper.startDrag(viewHolder);//拖曳互换 。也可以用其他的操作需要触发这个拖曳（默认是长按）， 测试发现 这里不调用都没关系
        //mItemTouchHelper.startSwipe(viewHolder);//左滑
    }
}
