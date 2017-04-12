package com.yahier.androidtest.test;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yahier.androidtest.R;
import com.yahier.androidtest.widget.BitmapShaders;
import com.yahier.androidtest.widget.CircleImageDrawable;

/**
 * Created by yahier on 17/4/12.
 */

public class DrawableAct extends AppCompatActivity {
    LinearLayout linearLayout;
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawable_test);

        linearLayout = (LinearLayout) findViewById(R.id.lin);
        img = (ImageView) findViewById(R.id.img1);
        testCircleDrawable();
        showBitmapShader();
    }


    /**
     * 显示圆形drawable
     */
    void testCircleDrawable() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.wukong);
        img.setImageDrawable(new CircleImageDrawable(bitmap));
    }


    void showBitmapShader() {
        View bitmapShaders = new BitmapShaders(this);
        linearLayout.addView(bitmapShaders);

    }
}
