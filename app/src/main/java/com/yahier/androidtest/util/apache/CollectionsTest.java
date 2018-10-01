package com.yahier.androidtest.util.apache;


import android.util.Log;

import com.annimon.stream.Stream;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.bidimap.TreeBidiMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by yahier on 10/1/18.
 * 测试apache-common collections 测试不通
 */

public class CollectionsTest {
    static String TAG = "CollectionsTest";

    public static void main() {
        test1();
        test2();
    }

    private static void test1() {
        List<String> list1 = Arrays.asList("yahier", "bingo");
        List<String> list2 = Arrays.asList("yahier", "soso");

        //交集
        Collection<String> result1 = CollectionUtils.retainAll(list1, list2);
        Stream.of(result1).forEach(item -> System.out.print("test1 " + item + " "));

        System.out.println();

        //并集
        Collection<String> result2 = CollectionUtils.union(list1, list2);
        Stream.of(result2).forEach(item -> System.out.print(item + " "));
    }


    private static void test2() {
        //双向map
        BidiMap bidiMap = new TreeBidiMap();
        bidiMap.put("yahier", "6");
        Log.d(TAG, "test2 " + String.valueOf(bidiMap.getKey("yahier")));
        Log.d(TAG, "test2 " + String.valueOf(bidiMap.get("6")));
    }

}
