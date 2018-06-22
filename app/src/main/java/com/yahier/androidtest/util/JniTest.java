package com.yahier.androidtest.util;

/**
 * Created by yahier on 2018/4/7.
 */

public class JniTest {
    static {
        System.loadLibrary("jni-test");
    }

    public static void main(String[] args) {
        JniTest test = new JniTest();
        System.out.println(test.get());
        test.set("yahier.dongguan");
    }

    public native String get();
    public native void set(String str);
}
