package com.yahier.androidtest.metarial;

import android.annotation.TargetApi;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.util.HandlerAsync;

/**
 * Created by yahier on 17/4/15.
 * SVG 可缩放矢量图形 = Scalable Vector Graphics
 */

public class VectorSVGAct extends BaseActivity {
    private TextView tvTip;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vector_svg_test);
        tvTip = (TextView) findViewById(R.id.tvTip);
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


    public void btnTest(View view) {
        new HandlerAsync().execute(new HandlerAsync.Listener() {
            @Override
            public String getResult() {
                SystemClock.sleep(5000);
                return "yahier will be rich";
            }

            @Override
            public void parse(String result) {
                tvTip.setText(result);
            }
        });

    }
}
