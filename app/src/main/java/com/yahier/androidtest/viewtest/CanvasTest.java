package com.yahier.androidtest.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/1/8.
 */

public class CanvasTest extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.canvas_test);

        ViewCanvas view = new ViewCanvas(this);
        setContentView(view);
    }


    public class ViewCanvas extends View {

        public ViewCanvas(Context context) {
            super(context);
        }


        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            testCanvasSaveAndRestore(canvas);
        }
    }


    void testCanvasSaveAndRestore(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStrokeWidth(10);
        paint.setColor(getResources().getColor(R.color.white));
        canvas.drawLine(100, 100, 800, 100, paint);

        canvas.save();
        canvas.rotate(5);
        canvas.translate(200, 0);
        canvas.scale(1.5f, 1.5f);

        paint.setColor(getResources().getColor(R.color.red));
        canvas.drawLine(100, 500, 800, 500, paint);


        canvas.restore();

        paint.setColor(getResources().getColor(R.color.blue));
        canvas.drawLine(100, 900, 800, 900, paint);
    }
}
