package com.yahier.androidtest;

import android.app.Activity;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by yahier on 1/6/19.
 * robolectric单元框架测试
 */
@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 19)
public class RoboTest {
    private final String TAG = "RoboTest";

    @Test
    public void test1() {
        Activity activity = Robolectric.setupActivity(MainActivity.class);
        assert activity.getTitle().equals("MainActivity");
        Log.e(TAG, "test1");

    }
}
