package com.yahier.androidtest.util;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AMSInvocationHandler implements InvocationHandler {

    private static final String TAG = "AMSInvocationHandler";

    Object iamObject;

    public AMSInvocationHandler(Object iamObject) {
        this.iamObject = iamObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //            Log.e(TAG, method.getName());
        if ("startActivity".equals(method.getName())) {
            Log.i(TAG, "ready to startActivity");
            for (Object object : args) {
                Log.d(TAG, "invoke: object=" + object);
            }
        }
        return method.invoke(iamObject, args);
    }
}
