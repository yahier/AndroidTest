package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import myutil.Log;

/**
 * Created by yahier on 17/3/29.
 * 易房秀的面试题。给数组排序，根据数字递增的形式
 */

public class Sort {
    String[] array = {"张7风", "独孤9剑", "天龙8部5兄弟"};

    public final static void main(String[] args) {
        Sort sort = new Sort();
        sort.test2();
    }

    void test() {
        //得到对应的数字数组
        int[] nums = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            nums[i] = getIntFromString(array[i]);
        }


        //将数组clone一份，用clone出来的一份排序.再来依次查询到索引，根据索引值，建立新的字符串数组。依次填充。太麻烦了。。

    }

    //以下是第二种方法
    void test2() {
        List<String> list = Arrays.asList(array);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                if (getIntFromString(s) > getIntFromString(t1)) {
                    return 1;
                } else if (getIntFromString(s) == getIntFromString(t1)) {
                    return 0;
                } else {
                    return -1;
                }

            }
        });

        for (String str : list) {
            Log.e("test2", "" + str);
        }

    }



    int getIntFromString(String str) {
        Pattern pattern = Pattern.compile("[0-9]");
        Matcher matcher = pattern.matcher(str);
        ArrayList<Integer> list = new ArrayList<Integer>();

        while (matcher.find()) {
            String con = matcher.group();
            list.add(new Integer(con));
        }
        return getMaxOfArray(list);
    }

    int getMaxOfArray(ArrayList<Integer> list) {
        Integer[] ints = new Integer[list.size()];
        ints = list.toArray(ints);
        int max = ints[0];
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
        }
        return max;

    }



}
