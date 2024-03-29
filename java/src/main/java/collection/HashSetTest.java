package collection;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import pojo.Book;


/**
 * Created by yahier on 17/7/18.
 */

public class HashSetTest {
    public static void main(String[] args) {
        //test();
        test2();
        //test3();
        //test4_List_delete();
        //test5_Set_Delete();
        //test5();
    }


    /**
     * 测试HashMap扩容规律. todo 待续
     */
    static void test5() {
        HashMap<String, Integer> map = new HashMap(20,1);
        for (int i = 0; i < 13; i++) {
            map.put("" + i, i);
        }

        Class mClass = map.getClass();
        try {
            Field field = mClass.getDeclaredField("threshold");
            try {
                field.setAccessible(true);
                Object object = field.get(map);
                System.out.println("object:" + object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    static void test() {
        Set<Book> set = new HashSet<>();
        Book book1 = new Book("九阴真经", "黄裳");
        Book book2 = new Book("九阴真经", "黄裳");
        set.add(book1);
        set.add(book2);
        System.err.println("set size:" + set.size());//打印 1
    }

    static void test2() {
        Book book1 = new Book("九阴真经", "黄裳");
        Book book2 = new Book("九阴真经", "黄裳");
        List<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        System.err.println("test2 list size:" + list.size());//打印 2

        Set<Book> set = new HashSet<>(list);
        List<Book> list1 = new ArrayList<>();
        Book book3 = new Book("九阴真经", "黄裳1");
        Book book4 = new Book("九阴真经1", "黄裳1");
        list1.add(book3);
        list1.add(book4);

        set.addAll(list1);
        System.err.println("test2 set size:" + set.size());//打印 1
    }

    static void test3() {
        Book book1 = new Book("九阴真经", "黄裳");
        Book book2 = new Book("九阴真经", "黄裳");
        Book book3 = new Book("九阴真经", "黄裳");
        List<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        if (list.contains(book3)) {
            System.err.println("contain了");
        }
        //boolean result = list.remove(book3);
        System.err.println(":" + list.size());

        List<Book> list2 = new ArrayList<>();
        list2.add(book3);

        list.addAll(list2);
        System.err.println(":" + list.size());
    }


    static void test4_List_delete() {
        Book book1 = new Book("九阴真经", "黄裳");
        Book book2 = new Book("九阴真经", "黄裳");
        List<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);

        book1.name = "葵花宝典";
        boolean result = list.remove(book1);//list照旧可以删除
        System.err.println("result:" + result + " size:" + list.size());
    }

    static void test5_Set_Delete() {
        Book book1 = new Book("九阴真经", "黄裳");
        Book book2 = new Book("九阴真经", "黄裳");
        Set<Book> set = new HashSet<>();
        set.add(book1);
        set.add(book2);
        book1.name = "葵花宝典";
        boolean result = set.remove(book1);//改属性后 不是之前的对象，删不了了。
        System.err.println("result:" + result + " size:" + set.size());
    }
}
