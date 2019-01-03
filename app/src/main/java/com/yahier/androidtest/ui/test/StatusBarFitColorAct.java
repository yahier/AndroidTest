package com.yahier.androidtest.ui.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.graphics.Palette;
import android.view.WindowManager;
import android.widget.ImageView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 2018/1/15.
 * 测试状态栏随图片变色(类名写的有偏差)
 */

public class StatusBarFitColorAct extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toor_fitcolor_act);
        notShowToolBar();
        setColorFit();
    }

    void notShowToolBar() {
        ActionBar bar = getSupportActionBar();
        bar.hide();
    }

    //哪里设置错了呢，没有达成效果呀
    void setColorFit() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.sunset);
        Palette palette = Palette.from(bitmap).generate();
        ImageView img1 = (ImageView) findViewById(R.id.img1);
        img1.setImageBitmap(bitmap);

        int vibrant = palette.getVibrantColor(0x000000);//vibrant鲜艳色
        int vibrantLight = palette.getLightVibrantColor(0x000000);//鲜艳色中的暗色
        int vibrantDark = palette.getDarkVibrantColor(0x000000);//鲜艳色中的暗色
        int muted = palette.getMutedColor(0x000000);//柔和色
        int mutedLight = palette.getLightMutedColor(0x000000);//柔和色中的亮色
        int mutedDark = palette.getDarkMutedColor(0x000000);//柔和色中的暗色
        int dominanColor = palette.getDominantColor(0x000000);//主导色

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);//也是一定要的
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            //此处可以重新指定状态栏颜色
            tintManager.setStatusBarTintColor(muted);
        }

    }
}
