package com.yahier.androidtest.bitmap;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.yahier.androidtest.R;


/**
 * 测试 preRotate  setRotate postRotate
 * @author yahier
 *
 */
public class MatrixTest extends Activity {
	ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.porter);
		img = (ImageView) findViewById(R.id.gua_round);


	}

	void setRotate() {
		BitmapDrawable db  =(BitmapDrawable)getResources().getDrawable(R.drawable.tab_left_bg);
		Bitmap bitmap = db.getBitmap();
		
		Matrix matrix = new Matrix();
	    //matrix.postRotate(90);//旋转90度
		//matrix.preScale(0.5f, 0.5f);//缩小一半
		
		matrix.setTranslate(100, 100); //神奇啊  为什么这里不移动呢
		Bitmap b = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		img.setImageBitmap(b);
	}
}
