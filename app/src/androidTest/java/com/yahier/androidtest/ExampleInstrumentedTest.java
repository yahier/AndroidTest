package com.yahier.androidtest;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.yahier.androidtest.multipleThreads.ThreadPoolAct;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void test1() throws Exception {
        Log.e("ExampleInstrumentedTest", "test1");
    }


    /**
     * TODO 怎么不能页面跳转呢  提示Client not ready yet..
     */
    @Ignore
    public void test2() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        Intent intent = new Intent(appContext, ThreadPoolAct.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Log.e("ExampleInstrumentedTest", "test2");
        appContext.startActivity(intent);
    }
}
