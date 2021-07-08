package com.yahier.androidtest.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.yahier.androidtest.R;

public class PicassoUtil {



    //加载图片，但用act的对象和application的对象，没有测试内存回收相关的差别
    public static void loadStatusesCropCenter(Context mContext, String imgUrl, int width, int Height, ImageView img) {
        Glide.with(mContext)
                .load(imgUrl)
                .centerCrop()
                .placeholder(R.drawable.default_square_image)
                .error(R.drawable.default_square_image)
                .override(width, Height)
                .into(img);
    }


    //加载图片，但用act的对象和application的对象，没有测试内存回收相关的差别
    public static void loadImg(Context mContext, String imgUrl, int width, int Height, ImageView img) {
        Glide.with(mContext)
                .load(imgUrl)
                .placeholder(R.drawable.default_square_image)
                .error(R.drawable.default_square_image)
                //.override(width, Height)
                .into(img);
    }




}
