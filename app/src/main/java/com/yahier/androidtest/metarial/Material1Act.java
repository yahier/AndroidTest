package com.yahier.androidtest.metarial;

import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 16/12/30.
 * <p>
 * note:   https://developer.android.google.cn/training/material/shadows-clipping.html
 */

public class Material1Act extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // enable transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.material_1);
        testTranslationZ();
    }


    void testTranslationZ() {
        TextView tv2 = (TextView) findViewById(R.id.tv2);
        TextView tv3 = (TextView) findViewById(R.id.tv3);
        //ObjectAnimator.ofFloat(tv2, "translationZ", 0, 50).setDuration(3000).start();


        tv2.setTranslationZ(180);
        tv3.setTranslationZ(0);
    }


}
