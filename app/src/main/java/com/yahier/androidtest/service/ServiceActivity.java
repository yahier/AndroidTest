package com.yahier.androidtest.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/1/4.
 */

public class ServiceActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_act);
        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.bind).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);
        findViewById(R.id.interaction).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.start:
                intent = new Intent(this, OneService.class);
                startService(intent);
                break;
            case R.id.bind:
                intent = new Intent(this, OneService.class);
                bindService(intent, connection, 0);
                startService(intent);
                break;
            case R.id.stop:
                break;
            case R.id.interaction:
                if (tService != null) {
                    tService.test();
                }
                break;
        }
    }


    OneService tService;
    private ServiceConnection connection = new ServiceConnection() {

        public void onServiceConnected(ComponentName name, IBinder service) {
            tService = ((OneService.LocalBinder) service).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }

    };
}