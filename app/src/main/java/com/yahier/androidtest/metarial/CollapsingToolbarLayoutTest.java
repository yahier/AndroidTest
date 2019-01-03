package com.yahier.androidtest.metarial;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 2018/1/16.
 * 测试 屏幕滚动时，收缩Toolbar的效果
 */

public class CollapsingToolbarLayoutTest extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar_layout_test);
        notShowToolBar();
    }

    void notShowToolBar() {
        ActionBar bar = getSupportActionBar();
        bar.hide();
    }
}
