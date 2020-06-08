package com.yahier.androidtest.view.act;

import android.os.Bundle;

import com.yahier.androidtest.R;

/**
 * .当activity不需要侧滑关闭时,setEnableGesture(false);
 */
public class SwipeBackMainActivity extends com.yahier.androidtest.BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act);

//        Button btn = (Button) findViewById(R.id.btn1);
//        btn.setText("开始吧");
//        findViewById(R.id.btn2).setVisibility(View.GONE);
//        findViewById(R.id.btn3).setVisibility(View.GONE);
//        findViewById(R.id.btn4).setVisibility(View.GONE);
//        btn.setOnClickListener(new OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                startActivity(new Intent(SwipeBackMainActivity.this,
//                        SwipeBackSecondActivity.class));
//            }
//        });
    }
}
