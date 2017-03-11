package com.yahier.androidtest.metarial;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

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

        //去掉此之后，查看删除是否还有动画效果
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


        final String[] myDataset = {"我不知道玩什么这样", "动起来", "为新的力量喝彩", "每一秒都期待", "东周列国志", "左转 周天子啊", "战国后期,秦国愈加强大,其它为了过了对抗秦国,", "开始用各种手段网络天下人才", "食客或者门客开始兴起", "后世开始有记录战国四公子的事情了", "信陵君窃符救赵,春申君", "曾一起走过的日子"};
        final MyAdapter mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                deleteHead(myDataset);
                //配合DefaultItemAnimator就有动画效果了
                mAdapter.notifyItemRemoved(0);
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
