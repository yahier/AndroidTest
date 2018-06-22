package test;

import java.util.ArrayList;
import java.util.List;

import pojo.People;

/**
 * Created by yahier on 2018/5/17.
 */

public class ListManager {

    private static List<People> list = new ArrayList<>();

    public static void main(String[] args) {
        test1();
        test2();
        //Test1.test();
        //System.out.println("size:" + list.size());
    }

    static void test1() {
        list.add(new People("1", "11", 111));
        list.add(new People("2", "22", 222));
        list.add(new People("3", "33", 333));
    }

    static void test2() {
        List<People> listNew = new ArrayList<>(3);

//
        for (People people : list) {
            try {
                listNew.add(people.clone());
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }

        //listNew.addAll(list);
        People people = listNew.get(1);
        people.setName("啊啊啊");
        listNew.set(1, people);

        for (People p : list) {
            System.out.println("name:" + p.getName());
        }

    }

    public static List<People> getList() {
        return list;
    }
}
