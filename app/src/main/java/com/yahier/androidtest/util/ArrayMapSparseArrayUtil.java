package com.yahier.androidtest.util;

import android.provider.Settings;
import android.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;

/**
 * Created by yahier on 17/4/22.
 */

public class ArrayMapSparseArrayUtil {
    static final String TAG = "ArrayMapSparseArrayUtil";

    public static final void main(String[] args) {
        Log.e(TAG, "main");
        testArrayMap();
        testSparseArray();
    }


    public static void testArrayMap() {
        ArrayMap<Integer, String> map = new ArrayMap<Integer, String>();
        map.put(1, "徐子旺");
        map.put(2, "罗曼");
        map.put(3, "海飞");
        map.put(4, "soso");
        map.put(5, "花");
        Log.e(TAG, "testArrayMap size:" + map.size());
        map.remove(1);
        Log.e(TAG, "testArrayMap size:" + map.size());
    }

    public static void testSparseArray() {
        SparseArray<String> map = new SparseArray<String>();
        map.append(1, "徐子旺");
        map.put(1, "罗曼");
        map.append(1, "海飞");
        map.append(4, "soso");
        map.append(5, "花");
        Log.e(TAG, "testSparseArray size:" + map.size());
        Log.e(TAG, map.valueAt(0));
    }
}
