package com.yahier.androidtest.util.apache.collection;


import android.util.Log;

import com.annimon.stream.Stream;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by yahier on 10/1/18.
 * 测试apache-common collections 测试不通
 */

public class CollectionsTest {
    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        List<String> list1 = Arrays.asList("yahier", "bingo");
        List<String> list2 = Arrays.asList("yahier", "soso");

        Collection<String> result1 = CollectionUtils.retainAll(list1, list2);
        Log.e("test1", "size:" + result1.size());
        Stream.of(result1).forEach(System.out::println);

        int a = org.apache.commons.collections4.ListUtils.indexOf(list1, item -> {
            return true;
        });

        Log.e("test1", "a:" + a);
    }
}
