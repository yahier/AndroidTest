package com.yahier.androidtest.ui.test;


import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yahier on 1/22/19.

 */

public class DataManager {
    private static String[] nameFirst = "邱赵钱龚孙李王徐汤杨于朱钟牛苟温吴刘蔡张程熊谢方杨木".split("");
    private static String[] nameMiddle = "子小佳少晓孝志伟一玉昌友瑞静申家海汉无".split("");
    private static String[] nameLast = "玲明浩洁旺汇丰军萍静敏杰根优珠远威海虎湖婉勇桂客一媛波清".split("");

    public static List<People> getList(int size, int offSize) {
        List<People> list = new ArrayList<>(size);
        for (int i = offSize; i < size + offSize; i++) {
            People people = new People();
            int index1, index2 = 0, index3;
            if (i < nameFirst.length) {
                index1 = i;
            } else {
                index1 = i % nameFirst.length;
            }


            if (i < nameMiddle.length) {
                index2 = i;
            } else {
                index2 = i % nameMiddle.length;
            }


            if (i < nameLast.length) {
                index3 = i;
            } else {
                index3 = i % nameLast.length;
            }
            String firstName = nameFirst[index1];
            if (TextUtils.isEmpty(firstName)) {
                index1 = new Random().nextInt(nameFirst.length);
                firstName = nameFirst[index1];
            }


            String middleName = "    ";
            if (i % 6 != 0) {
                if (!nameMiddle[index2].equals("")) {
                    middleName = nameMiddle[index2];
                }
            }


            String lastName = nameLast[index3];
            if (TextUtils.isEmpty(lastName)) {
                index3 = new Random().nextInt(nameFirst.length);
                lastName = nameFirst[index3];
            }

            people.setName(firstName + middleName + lastName);
            list.add(people);
        }
        return list;
    }
}
