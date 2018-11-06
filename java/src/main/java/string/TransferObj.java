package string;

/**
 * Created by yahier on 11/1/18.
 * 对象传值测试
 */

public class TransferObj {
    public static void main(String[] args) {
        Person p = new Person("张三");

        change(p);//不改变原值
        //change2(p);//改变原值

        System.out.println(p.name);
    }

    private static void change(Person p) {
        Person person = new Person("李四");
        p = person;
    }

    private static void change2(Person p) {
        p.name = "李思";
    }
}

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

