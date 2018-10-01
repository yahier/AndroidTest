package com.yahier.androidtest.util.apache.beanutils;

import android.util.Log;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.BeanUtilsBean2;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by yahier on 10/1/18.
 * 测试apache-common的BeanUtils 测试不通
 */

public class BeanUtilsTest {
    private static final String TAG = "BeanUtilsTest";


    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        BeanUtilsBean beanUtilsBean = new BeanUtilsBean2();
        User user = new User();
        try {
            beanUtilsBean.setProperty(user, "name", "yahier");
            String name = beanUtilsBean.getProperty(user, "name");
            Log.e(TAG, "test1 " + name);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

}
