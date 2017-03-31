package com.yahier.androidtest.test;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by yahier on 17/3/31.
 */

public class MyBraodCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("MyBraodCastReceiver", intent.getAction());

    }
}
