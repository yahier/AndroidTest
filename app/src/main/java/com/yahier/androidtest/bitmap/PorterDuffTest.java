package com.yahier.androidtest.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.yahier.androidtest.R;


public class PorterDuffTest extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.porter);
		ImageView img = (ImageView)findViewById(R.id.gua_round);
		img.setImageBitmap(getRoundedCornerBitmap());
	}
	
	
	/**
	 * 先画一个圆角矩形，再画一个bitmap,用SRC_IN模式 重叠。
	 * @return
	 */
	public Bitmap getRoundedCornerBitmap(){
		BitmapDrawable db  =(BitmapDrawable)getResources().getDrawable(R.drawable.tab_left_bg);
		Bitmap bitmap = db.getBitmap();
		Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getWidth(), Config.ARGB_8888);
		Canvas canvas = new Canvas(output);
		final Paint paint = new Paint(Color.GREEN);
		final Rect rect = new Rect(0,0,bitmap.getWidth(),bitmap.getHeight());
		
		final RectF rectF = new RectF(rect);
		final float roundPx=90;//设置圆角半径20
		paint.setAntiAlias(true);//设置抗锯齿效果  就是平滑效果
		canvas.drawRoundRect(rectF, roundPx, roundPx, paint);
		paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));//重叠模式
		canvas.drawBitmap(bitmap, rect, rect, paint);
		return output;
	}

}
