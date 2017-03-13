package com.yahier.androidtest.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.yahier.androidtest.R;
import com.yahier.androidtest.util.PicassoUtil;

import java.util.List;


/**
 * @author lenovo 动态九宫格图.动态短微博主页 微博动态详细.社区 都用到了这里.
 */

public class GVImgAdapter extends CommonAdapter {
    public final static int gridColumn = 3;
    Context mContext;
    int itemWidth = 600;
    List<String> data;


    /**
     * 列表上显示的
     *
     * @param mContext
     */
    public GVImgAdapter(Activity mContext, List<String> data) {
        this.mContext = mContext;
        this.data = data;


    }


    @Override
    public int getCount() {
        return data.size();
    }

    class CityHolder {
        ImageView item_iv;
    }

    @Override
    public View getView(final int i, View con, ViewGroup parent) {
        CityHolder ho = null;
        if (con == null) {
            ho = new CityHolder();
            con = LayoutInflater.from(mContext).inflate(R.layout.gridview_img, null);
            ho.item_iv = (ImageView) con.findViewById(R.id.img);
            con.setTag(ho);
        } else
            ho = (CityHolder) con.getTag();

        String imgUrl = data.get(i);

        PicassoUtil.loadStatusesCropCenter(mContext, imgUrl, itemWidth, itemWidth, ho.item_iv);


        return con;
    }


}
