package test;

import pojo.People;

/**
 * Created by yahier on 17/3/1.
 * 测试没有完成,计划set,get测试,和直接用数据解析为People对象,再get测试
 */

public class EnumTest {
    People[] peoples = new People[4];

    public final static void main(String[] args) {
        testPeople();
    }


    static void testPeople() {

        People p = new People();
        p.setAge(12);
        p.setName("soso");
        //第一种写法竟然没通过,就说明哪里出问题了。
        //p.setGender(People.Gender.valueOf("yahier"));
        p.setGender(People.Gender.BOY);

        People.Gender gender = p.getGender();
        System.out.println("yahier:" + gender.getCode());
        System.out.println("yahier:" + gender.ordinal());

        // TODO



    }
}
