package com.yahier.androidtest.metarial;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.util.Log;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 2018/1/16.
 * 测试 屏幕滚动时，收缩Toolbar的效果
 */

public class CollapsingToolbarLayoutTest extends BaseActivity {
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.collapsing_toolbar_layout_test);

        appBarLayout = findViewById(R.id.layout_appbar);
        notShowToolBar();
        observerScroll();
    }


    void notShowToolBar() {
        ActionBar bar = getSupportActionBar();
        bar.hide();
    }


    /**
     * 监听滑动，将滑动的数值转换成状态
     */
    void observerScroll() {
        appBarLayout.addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            Log.e("滑动监听", "首页appBar verticalOffset：" + verticalOffset);
            hide();
            handler.removeMessages(1);
            handler.sendEmptyMessageDelayed(1,2000);
        });
    }


    private boolean isScrolling = false;

    private  Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            isScrolling = false;
            show();
            return false;
        }
    });


    private void show(){
        Log.e("滑动监听","收到消息了，show");
    }

    private void hide(){
        if(isScrolling){
            return;
        }
        isScrolling = true;
        Log.e("滑动监听","收到消息了，hide");

    }







}
