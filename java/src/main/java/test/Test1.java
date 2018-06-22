package test;

import java.util.List;

import pojo.People;

/**
 * Created by yahier on 2018/5/17.
 */

public class Test1 {


    public static void test() {
        List<People> list = ListManager.getList();
        People people = list.get(0);
        people.setName("000000");
        list.add(new People("", "", 4));
    }
}
