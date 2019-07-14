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
        //testHashMap();
        //testHasTable();
        //testMove();
        testKey();
    }


    /**
     * Q:此方法有疑问点，既然两个对象不同，为什么没有出现hash冲突。而是进行了替代。
     * A：解答:如果对象的hash和equals都相等，那么map会进行替换；如果hash相同而equals不相等，那么会出现hash冲突。
     */
    private static void testKey() {
        Key key1 = new Key("yahier", "soga");
        Key key2 = new Key("yahier", "soga");

        System.out.println(key1.hashCode());
        System.out.println(key2.hashCode());

        System.out.println(key1 == key2);

        Map<Key, String> map = new HashMap<>();
        map.put(key1, "key1");
        map.put(key2, "key2");

        System.out.println("map size:" + map.size());

        Set<Map.Entry<Key, String>> set = map.entrySet();
        for (Map.Entry<Key, String> entry : set) {
            System.out.println("hashMap " + entry.getKey() + ":" + entry.getValue());
        }

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
