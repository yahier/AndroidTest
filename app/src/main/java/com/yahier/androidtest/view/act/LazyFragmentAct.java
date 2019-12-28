package com.yahier.androidtest.view.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.widget.SimpleFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试Fragment按需加载
 * 如果有1000个题目，需要用Fragment展示，但数据可能每次只有10条。假定数据都是分批来的。
 * 方法1是初始化时定下的fragment就是1000个，滑动过程中改变数据。
 * 方法2是fragment固定，只在滑动中改变数据的内容。
 *
 * todo 最好的办法还是分批次生成fragment
 */
public class LazyFragmentAct extends BaseActivity {
    ViewPager mViewPager;
    Adapter adapter;
    int pageCount = 5;
    final String TAG = "LazyFragmentAct";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_lazy_fragment);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        adapter = new Adapter();
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(0);


        List<String> data = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            data.add(String.valueOf(i));
        }
        adapter.setData(data);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == adapter.getCount() - 1) {
                    adapter.addData(getNewData());
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


    }


    public List<String> getNewData() {
        int init = adapter.getMaxData() + 1;
        List<String> data = new ArrayList<>();
        for (int i = init; i < init + 5; i++) {
            data.add(String.valueOf(i));
        }
        return data;
    }

    public class Adapter extends FragmentStatePagerAdapter {
        private List<String> data;

        public int getMaxData() {
            return Integer.parseInt(data.get(data.size() - 1));
        }

        public Adapter() {
            super(getSupportFragmentManager());
            this.data = new ArrayList<>();
        }

        public void setData(List<String> data) {
            this.data = data;
            notifyDataSetChanged();
        }

        public void addData(List<String> data) {
            this.data.addAll(data);
            notifyDataSetChanged();
        }

        @Override
        public Fragment getItem(int position) {
            return SimpleFragment.newInstance("Position:" + data.get(position));
        }

        @Override
        public int getCount() {
            return data.size();
        }
    }
}
