package com.yahier.androidtest.test;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;
import com.yahier.androidtest.common.MyApp;

/**
 * Created by yahier on 17/1/27.
 */

public class WindowTest extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        test();
    }

    void test(){
        getWindow().getDecorView().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.e("WindowTest","testToast");
                testToast();
            }
        },2000);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("WindowTest","onDestroy");
    }

    //Toast可以在activity回收后调用. 而且Context可以用Application.
    void testToast(){
        Toast.makeText(MyApp.getContext(),"你好啊",Toast.LENGTH_SHORT).show();
    }

    //Dialog不可以在activity回收后调用.只能用Activity的Context
    void testDialog(){
        Dialog dialog = new Dialog(MyApp.getContext());
        dialog.setTitle("nihao");
        dialog.setContentView(R.layout.circle);
        dialog.show();
    }
}
