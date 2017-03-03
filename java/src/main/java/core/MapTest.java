package core;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by yahier on 17/3/3.
 * Hashtable的key和value都不能为null.糟糕的是编译没有问题,运行出现空指针:Hashtable的大部分方法都同步了
 */

public class MapTest {
    public final static void main(String[] args) {
        testHashMap();
        testHasTable();
        testMove();
    }


    static void testMove() {
        int a = 2;
        a = a << 3;//向左位移3位
        System.out.println("a:" + a);
    }

    static void testHashMap() {
        HashMap<String, String> map = new HashMap<>(8);
        map.put("1", "1");
        map.put("1", "2");
        map.put(null, "1");
        map.put("", null);
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> tor = set.iterator();
        while (tor.hasNext()) {
            Map.Entry entry = tor.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("");
    }


    static void testHasTable() {
        Hashtable<String, String> map = new Hashtable<>(8);
        map.put("1", "1");
        map.put("1", "1");
        //key和value都不能为 null。运行会nullPointerException
        //map.put(null, "1");
        //map.put("", null);
        Set<Map.Entry<String, String>> set = map.entrySet();
        Iterator<Map.Entry<String, String>> tor = set.iterator();
        while (tor.hasNext()) {
            Map.Entry entry = tor.next();
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

}
