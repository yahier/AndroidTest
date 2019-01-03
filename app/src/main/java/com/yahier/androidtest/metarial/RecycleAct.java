package com.yahier.androidtest.metarial;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.MyAdapter;
import com.yahier.androidtest.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahier on 16/12/30.
 * 测试RecyclerView的动画，和DiffUtil功能
 */

public class RecycleAct extends BaseActivity {
    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_recycle);
        initRecycleView();
    }

    RecyclerView mRecyclerView;

    private void initRecycleView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //加上间隔线。这个操作还有更多强大的功能
        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
//                Paint paint = new Paint();
//                paint.setColor(Color.BLUE);
//
//                int childCount = parent.getChildCount();
//                for (int i = 0; i < childCount; i++) {
//                    View child = parent.getChildAt(i);
//                    int leftPosition = (int) child.getX();//getX()也是可以啦
//                    int rightPosition = leftPosition + child.getWidth();
//                    c.drawLine(leftPosition, child.getBottom(), rightPosition, child.getBottom(), paint);
//                }

            }


            /**
             * onDraw方法先于drawChildren
             * onDrawOver在drawChildren之后，一般我们选择复写其中一个即可。
             */
            @Override
            public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);
                Paint paint = new Paint();
                paint.setColor(Color.BLUE);

                int childCount = parent.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View child = parent.getChildAt(i);
                    int leftPosition = (int) child.getX();//getX()也是可以啦
                    int rightPosition = leftPosition + child.getWidth();
                    c.drawLine(leftPosition, child.getBottom(), rightPosition, child.getBottom(), paint);
                }

            }


            //getItemOffsets 可以通过outRect.set()为每个Item设置一定的偏移量，主要用于绘制Decorator。
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
            }


        });
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(false);

        //分别是线性layout和瀑布流layout
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);

        mRecyclerView.setLayoutManager(mLayoutManager);


        List<String> datas = new ArrayList<>();
        datas.add("我不知道为什么这样");
        datas.add("动起来");
        datas.add("为新的力量喝彩");
        datas.add("每一秒都期待");
        datas.add("东周列国志");
        datas.add("网罗门客");

        mAdapter = new MyAdapter(datas);
        mRecyclerView.setAdapter(mAdapter);

        //这里的动画都只移动了内容，间隔线没有移动
        mRecyclerView.postDelayed(() -> {
            //配合DefaultItemAnimator就有动画效果了


            //方案1 没有动画效果
//            datas.remove(0);
//            mAdapter.setData(datas);
//            mAdapter.notifyDataSetChanged();

            //方案2 有动画效果（无论有没有设置setItemAnimator）
//            datas.remove(0);
//            mAdapter.setData(datas);
//            mAdapter.notifyItemRemoved(0);

            //方案3 有动画 无论有没有设置setItemAnimator）
            testDiffUtil(datas);
        }, 2000);
    }


    //测试一下DiffUtil 效果OK，暂时
    private void testDiffUtil(List<String> mDatas) {
        List<String> datasNew = new ArrayList<>();
        datasNew.add("每一秒都期待");
        datasNew.add("东周列国志");
        datasNew.add("网罗门客");
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new DiffCallBack(mDatas, datasNew), true);
        diffResult.dispatchUpdatesTo(mAdapter);
        mAdapter.setData(datasNew);

    }


}
