package com.yahier.androidtest.test;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.yahier.androidtest.BaseActivity;
import com.yahier.androidtest.R;

/**
 * Created by yahier on 17/5/31.
 */
@Route(path = "/cn/bookings/tickets_service/ticket_booking/index.shtml",extras = 100)
public class AppLinkTestAct extends BaseActivity {
    final String TAG = "AppLinkTestAct";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");

        setContentView(R.layout.app_link_act);

        Uri uri = getIntent().getData();
        if (uri == null) {
            Log.e(TAG, "url is null");
        } else {
            Log.e(TAG, uri.getPath());
        }

    }


}
