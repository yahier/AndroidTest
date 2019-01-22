package com.yahier.androidtest.ui.test;

/**
 * Created by yahier on 17/3/1.
 */

public class People implements Cloneable {


    public People() {
        System.err.println("people构造函数");
    }

    public People(String name) {
        this.name = name;
    }

    public People(String name, String pwd, int age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
    }

    @Override
    public People clone() throws CloneNotSupportedException {
        return (People) super.clone();
    }

    int age;


    int gender;

    public void setGender(int genger) {
        this.gender = genger;
    }

    public int getGender() {
        return gender;
    }

    String name;
    String pwd;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPwd() {
        return pwd;
    }

    //4月9日 新增
    public enum GenderStatus {
        Boy(1, "男生"),
        Girl(2, "女生");
        int code;
        String msg;

        GenderStatus(int code, String msg) {
            this.code = code;
            this.msg = msg;
        }


        public int getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

//    @Override
//    public int hashCode() {
//        System.out.println("People hashCode...");
//        return 1023433;
//    }

//    @Override
//    public boolean equals(Object o) {
//        System.out.println("People equals...");
//        return true;
//    }
}
