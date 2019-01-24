package com.yahier.androidtest.ui.test;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yahier on 1/22/19.
 */

public class DataManager {
    private static String[] nameFirst = "邱赵钱龚孙李王徐汤杨于朱钟牛苟温吴刘蔡张程熊谢方杨木".split("");
    private static String[] nameMiddle = "子小佳少晓孝志伟一玉昌友瑞静申家海汉无".split("");
    private static String[] nameLast = "玲明浩旺汇丰军萍静敏杰根优珠远威海虎湖婉勇桂客一媛波清".split("");

    public static List<People> getList(int size) {
        List<People> list = new ArrayList<>(size);
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int index1 = random.nextInt(nameFirst.length);
            int index2 = random.nextInt(nameMiddle.length * 2);
            int index3 = random.nextInt(nameLast.length);

            String name1 = nameFirst[index1];
            String name2 = "    ";
            if (index2 < nameMiddle.length) {
                name2 = nameMiddle[index2];
            }
            String name3 = nameLast[index3];
            People people = new People(name1 + name2 + name3);
            list.add(people);
        }
        return list;
    }
}
