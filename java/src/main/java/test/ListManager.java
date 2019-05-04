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
        test2();
        //Test1.test();
        //System.out.println("size:" + list.size());
        test3();
    }

    static {
        list.add(new People("1", "11", 111));
        list.add(new People("2", "22", 222));
        list.add(new People("3", "33", 333));
    }

    /**
     * 测试 深浅拷贝
     */
    static void test2() {
        List<People> listNew = new ArrayList<>(3);

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

    static void test3() {
        People people1 = new People("1", "11", 111);
        try {
            People people2 = people1.clone();
            people2.setAge(22);
            people2.setName("22");
            System.out.println(people1.getAge() + " " + people1.getName());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static List<People> getList() {
        return list;
    }
}
