package com.yahier.androidtest.anim;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.yahier.androidtest.R;
import com.yahier.androidtest.widget.CircleImageDrawable;

/**
 * Created by yahier on 17/4/12.
 * 想用属性，表示一个圆的绘制动画
 */

public class DrawCircleAct extends AppCompatActivity {
    ImageView img;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anim_circle_act);

        img = (ImageView) findViewById(R.id.img);
       img =  (ImageView) findViewById(R.id.img);
        testCircleDrawable();
    }

    void test2(){
        //PackageManager packageManager = getPackageManager();
        //packageManager.setComponentEnabledSetting(receiver...);
    }

    void testCircleDrawable() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.drawable.default_square_image);
        img.setImageDrawable(new CircleImageDrawable(bitmap));
    }
}
