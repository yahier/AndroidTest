package array;

/**
 * Created by yahier on 17/1/26.
 */

public class People implements Comparable{
    int age;
    String name;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

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

    @Override
    public int compareTo(Object o) {
        return ((People)o).getAge() - getAge();
    }
}
