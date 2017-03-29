package pojo;

/**
 * Created by yahier on 17/3/1.
 */

public class People {


    public People(){

    }
    public People(String name, String pwd, int age) {
        this.name = name;
        this.pwd = pwd;
        this.age = age;
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
}
