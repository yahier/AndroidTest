package com.yahier.androidtest.classload;

import android.util.Log;

/**
 * Created by yahier on 17/3/21.
 */

public class ShowStringClass implements ShowString {

    public static final String TAG = "ShowStringClass";

    @Override
    public String sayChenyu() {
        String chenyu = "yahier.你好";
        Log.i(TAG, chenyu);
        return chenyu;
    }

}