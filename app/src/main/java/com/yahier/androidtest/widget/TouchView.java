package com.yahier.androidtest.widget;

import java.util.ArrayList;
import java.util.List;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.yahier.androidtest.R;

public class TouchView extends View {
	private Paint paint = null;
	List<Point> list;
	Bitmap bitmap;
	float left, top;

	public TouchView(Context context, AttributeSet attrs) {
		super(context, attrs);
		paint = new Paint();
		list = new ArrayList<Point>();
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.w);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Point point = new Point();
		if (event.getAction() == MotionEvent.ACTION_DOWN) {
			left = event.getX();
			top = event.getY();
			invalidate((int)left,(int)top,100,100);
			System.out.println("down");
			
			
			
		    
		}
		return super.onTouchEvent(event);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		canvas.drawBitmap(bitmap, left, top, paint);
		canvas.save();
		System.out.println("draw.");

	}
}
