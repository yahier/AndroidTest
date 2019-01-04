package collection;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

/**
 * Created by yahier on 17/3/3.
 * Hashtable和HashMap的比较
 * hashTable的key和value都不能为null.并且大部分方法都同步了
 */

public class MapTest {
    public static void main(String[] args) {
        testHashMap();
        testHasTable();
        testMove();
    }


    private static void testMove() {
        int a = 2;
        a = a << 3;//向左位移3位
        System.out.println("a:" + a);
    }

    private static void testHashMap() {
        HashMap<String, String> map = new HashMap<>(8);
        map.put("1", "1");
        map.put("1", "2");
        map.put(null, "1");
        map.put("", null);
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println("hashMap " + entry.getKey() + ":" + entry.getValue());
        }

        System.out.println("");
    }


    private static void testHasTable() {
        Hashtable<String, String> map = new Hashtable<>(8);
        map.put("1", "1");
        map.put("1", "1");
        //key和value都不能为 null。运行会nullPointerException
        //map.put(null, "1");
        //map.put("", null);
        Set<Map.Entry<String, String>> set = map.entrySet();
        for (Map.Entry<String, String> entry : set) {
            System.out.println("table " + entry.getKey() + ":" + entry.getValue());
        }

    }

}
