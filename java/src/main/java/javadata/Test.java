package javadata;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {
        TreeMap<String, String> treeMap1 = new TreeMap<String, String>();
        treeMap1.put("2", "1");
        treeMap1.put("b", "1");
        treeMap1.put("1", "1");
        treeMap1.put("a", "1");

        treeMap1.put("a", "a");//会覆盖以上。修改比较器会更明显的效果
        System.out.println("treeMap1=" + treeMap1);

        Map map = new HashMap<String,String>();
        map.put("name","bingo");


        //TreeMap如不指定排序器，默认将按照key值进行升序排序，如果指定了排序器，则按照指定的排序器进行排序。
        TreeMap<String, String> treeMap2 = new TreeMap<String, String>(
                new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        if (o1.length() != o2.length())
                            return o1.length() - o2.length();
                        else return o1.compareTo(o2);

                        //如果直接return 0;就相当key都是重复的。就只能写入一个值。直接返回正值，排序则按写入顺序；返回负数，则倒序。
                    }
                });
        treeMap2.put("21", "1");
        treeMap2.put("b", "1");
        treeMap2.put("11", "1");
        treeMap2.put("a", "1");
        System.out.println("treeMap2=" + treeMap2);


    }
}
