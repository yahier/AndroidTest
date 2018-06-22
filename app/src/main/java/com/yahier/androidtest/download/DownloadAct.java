package com.yahier.androidtest.download;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 2018/4/9.
 */

public class DownloadAct extends AppCompatActivity {
    final String url = "https://apk.apk.hz155.com/down/lypcdibutj.apk";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_download);

        findViewById(R.id.btn1).setOnClickListener(v->{

        });
    }


}
