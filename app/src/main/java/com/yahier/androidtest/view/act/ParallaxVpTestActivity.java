package com.yahier.androidtest.view.act;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.yahier.androidtest.R;
import com.yahier.androidtest.widget.SimpleFragment;

public class ParallaxVpTestActivity extends com.yahier.androidtest.BaseActivity {
    private ViewPager mViewPager;
    private int mTabCount = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parallax_vp_test);

        mViewPager = (ViewPager) findViewById(R.id.id_viewpager);

        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return
                        SimpleFragment.newInstance("Position:" + position);
            }

            @Override
            public int getCount() {
                return mTabCount;
            }

        });

        mViewPager.setCurrentItem(1);

    }
}
