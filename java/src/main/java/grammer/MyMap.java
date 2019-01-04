package grammer;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import pojo.People;

public class MyMap {
    public static void main(String[] args) {
        test();
        test2();
        test3();
    }

    /**
     * 测试HashMap
     */
    static void test() {
        HashMap map = new HashMap(10);
        People people = new People();
        People people2 = new People();
        map.put(people, "11");
        map.put("2", "12");
        map.put("3", "13");
        map.put(people2, "14");

        Set<?> set = map.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println("test:" + it.next());
        }

        System.out.println();
    }

    /**
     * 测试LinkedHashMap
     */
    static void test2() {
        LinkedHashMap map = new LinkedHashMap(10);
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        map.put("d", "4");

        Set<?> set = map.keySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            System.out.println("test2:" + it.next());
        }
        System.out.println();

    }

    /**
     * 测试TreeMap.可以根据key排序的map
     */
    static void test3() {
        //TreeMap构造函数的 参数可选
        Map map = new TreeMap<String, Object>(new Comparator<String>() {
            @Override
            public int compare(String t1, String t2) {
                return t2.compareTo(t1);
            }
        });
        map.put("Q", "Level Q");
        map.put("4", "Level 2");
        map.put("3", "Level 3");
        map.put("F", "Level F");
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("test3 Key: " + e.getKey() + "-" + e.getValue());

        }
    }

}
