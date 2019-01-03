package com.yahier.androidtest.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/1/20.
 */

public class ViewToBitmapAct extends BaseActivity implements View.OnClickListener {
    View rootView;
    ImageView img;
    final String TAG = "ViewToBitmapAct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_2_bitmap_act);
        rootView = findViewById(R.id.root);
        img = (ImageView) findViewById(R.id.img);
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                img.setImageBitmap(createViewBitmap(rootView));
                break;
            case R.id.btn2:
                Bitmap bitmap = loadBigMap();
                Log.e(TAG, "width:" + bitmap.getWidth());
                img.setImageBitmap(bitmap);
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

    /**
     * 图片太大，不能加载。只能加载到8192*8192
     *
     * @return
     */
    private Bitmap loadBigMap() {
        return BitmapFactory.decodeResource(getResources(), R.drawable.qm);
    }
}
