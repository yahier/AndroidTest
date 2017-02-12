package com.yahier.androidtest.view.act;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/2/11.
 *
 */

public class CommonViewTest extends Activity implements View.OnClickListener {
    final String tag = "CommonViewTest";
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);

        btn1 = (Button) findViewById(R.id.btn1);
        btn1.setText("空属性动画里 调用scrollTo");
        btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);

        btn1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                showAnimator();
                break;
            case R.id.btn2:
                break;
            case R.id.btn3:
                break;
        }

    }


    //btn的方法
    void showAnimator() {
        final int deltax = 100;
        ValueAnimator animator = ValueAnimator.ofInt(0, 1).setDuration(1000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                //有点像返回的比例的意思。值在(0-1之间)
                float fraction = valueAnimator.getAnimatedFraction();
                Log.e(tag, "onAnimationUpdate:" + fraction);
                btn1.scrollTo((int) (deltax * fraction), 0);
            }
        });

        animator.start();
    }
}
