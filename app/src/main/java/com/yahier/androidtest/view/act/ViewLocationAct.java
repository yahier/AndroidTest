package com.yahier.androidtest.view.act;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.yahier.androidtest.widget.ViewLocation;

/**
 * Created by Administrator on 2017/2/4.
 */

    public class ViewLocationAct extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewLocation view = new ViewLocation(this);

        setContentView(view);
        Toast.makeText(this,"weizhi",Toast.LENGTH_SHORT).show();

    }
}