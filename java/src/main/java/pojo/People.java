package pojo;

/**
 * Created by yahier on 17/3/1.
 */

public class People {


    int age;

    public enum Gender {
        BOY(1), GIRL(2);
        private int gender;

        private Gender(int gender) {
            this.gender = gender;
        }

        public int getCode() {
            return gender;
        }
    }

    int gender;

    public void setGender(int genger) {
        this.gender = genger;
    }

    public int getGender() {
        return gender;
    }

    String name;


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
}
