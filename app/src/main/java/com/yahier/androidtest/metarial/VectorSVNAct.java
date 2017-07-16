package com.yahier.androidtest.metarial;

import android.annotation.TargetApi;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/4/15.
 */

public class VectorSVNAct extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vector_svg_test);

    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void animL(View view) {
        ImageView imageView = (ImageView) view;
        AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) getDrawable(R.drawable.fivestar_anim);
        imageView.setImageDrawable(drawable);
        if (drawable != null) {
            drawable.start();
        }
    }
}
