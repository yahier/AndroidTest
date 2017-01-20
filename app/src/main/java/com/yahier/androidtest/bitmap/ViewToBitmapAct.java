package com.yahier.androidtest.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/1/20.
 */

public class ViewToBitmapAct extends Activity implements View.OnClickListener {
    View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_2_bitmap_act);
        rootView = findViewById(R.id.root);

        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                ImageView img = (ImageView) findViewById(R.id.img);
                img.setImageBitmap(createViewBitmap(rootView));
                break;
            case R.id.btn2:
                break;
        }

    }

    public Bitmap createViewBitmap(View v) {
        Bitmap bitmap = Bitmap.createBitmap(v.getWidth(), v.getHeight(),
                Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        v.draw(canvas);
        return bitmap;
    }
}
