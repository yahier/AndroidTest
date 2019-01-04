package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 存入层级对象
 */
public class MyList {

    public static void main(String[] args) {
        testList();
    }

    static void testList() {

        Map<Integer, String> cityMap = new HashMap<Integer, String>();
        cityMap.put(1, "inwg");
        cityMap.put(3, "wf");

        Map<Integer, Map> provinceMap = new HashMap<Integer, Map>();
        provinceMap.put(0, cityMap);
        provinceMap.put(1, cityMap);

        Map<Integer, Map> countryMap = new HashMap<Integer, Map>();
        countryMap.put(0, provinceMap);


    }

}
