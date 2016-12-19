package com.yahier.androidtest.test;


import android.app.Activity;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.yahier.androidtest.R;

/**
 * 圆环拨动
 * @author yahier
 *
 */
public class GuaRound extends Activity {
	ImageView gua_img;
	GestureDetector detector;
	float fromDegree = 0, toDegree = 0;
	Animation rotateAnimation;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gua_round);

		gua_img = (ImageView) findViewById(R.id.gua_round);
		detector = new GestureDetector(new MyGesture());

	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		return this.detector.onTouchEvent(event);
	}

	class MyGesture extends SimpleOnGestureListener {

		@Override
		public boolean onScroll(MotionEvent e1, MotionEvent e2,
				float distanceX, float distanceY) {
			//更准确的做法是在这里计算角度，并且判断方向
			rotateGua(2);
			return super.onScroll(e1, e2, distanceX, distanceY);
		}

		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			//rotateGua(30);
			return super.onFling(e1, e2, velocityX, velocityY);
		}

		/** 手指放上去时 开始反应 */
		@Override
		public boolean onDown(MotionEvent e) {
			return super.onDown(e);
		}

		@Override
		public void onLongPress(MotionEvent e) {
			// TODO Auto-generated method stub
			super.onLongPress(e);
		}

	}

	/** 旋转卦 参数需要是30的倍数 */
	void rotateGua(int degree) {
		rotateAnimation = new RotateAnimation(fromDegree, toDegree,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		rotateAnimation.setDuration(100);
		rotateAnimation.setFillAfter(true);
		gua_img.startAnimation(rotateAnimation);
		fromDegree += degree;
		toDegree += degree;

	}

}
