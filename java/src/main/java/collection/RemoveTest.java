package collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import pojo.People;

/**
 * Created by yahier on 17/3/29.
 */

public class RemoveTest {

    public static void main(String[] args) {
        test2();

    }

    static void test1() {
        Set<People> set = new HashSet<People>();
        People p1 = new People("唐僧", "pwd1", 25);
        People p2 = new People("孙悟空", "pwd2", 26);
        People p3 = new People("猪八戒", "pwd3", 27);
        set.add(p1);
        set.add(p2);
        set.add(p3);
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:3 个元素!
        p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变

        set.remove(p3); //此时remove不掉，造成内存泄漏

        // set.add(p3); //重新添加，居然添加成功
        System.out.println("总共有:" + set.size() + " 个元素!"); //结果：总共有:4 个元素!
        for (People person : set) {
            System.out.println(person.getAge());
        }
    }

    static void test2() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        //这样的删除就大有问题了。
//        for (String temp : list) {
//            if ("1".equals(temp) || "2".equals(temp)) {
//                list.remove(temp);
//            }
//        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            if ("1".equals(temp) || "2".equals(temp)) {
                it.remove();
            }
        }

        list.removeIf(temp -> "1".equals(temp) || "2".equals(temp));

        System.out.println("test2:" + list.size());
    }
}
