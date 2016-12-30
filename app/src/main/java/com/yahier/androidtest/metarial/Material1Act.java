package com.yahier.androidtest.metarial;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.view.View;
import android.view.Window;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 16/12/30.
 *
 * note:   https://developer.android.google.cn/training/material/shadows-clipping.html
 */

public class Material1Act extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // enable transitions
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.material_1);
    }



}
