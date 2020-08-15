package com.yahier.androidtest.view.act;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 2018/1/15.
 * 测试约束性布局。觉得没意思
 */

public class ConstraintLayoutTest extends com.yahier.androidtest.BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.constain_layout1);
        group1 = findViewById(R.id.group1);
        testAddContentView();
        delayedChangeGroupVisibility();
    }

    private void testAddContentView() {
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(200, 400);
        addContentView(getImageView(), params);
    }

    private View getImageView() {
        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.sunset);
        return img;
    }


    View group1;

    private void delayedChangeGroupVisibility() {
        getWindow().getDecorView().postDelayed(() -> {
            group1.setVisibility(View.GONE);
        }, 4000);

    }
}
