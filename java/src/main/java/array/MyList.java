package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyList {

	public static void main(String[] args) {
		testList();
	}

	static void testList() {

		// 城市map  多个
		Map<Integer, String> cityMap = new HashMap<Integer, String>();
		cityMap.put(1, "珠海");
		cityMap.put(3, "广州");

		// 省份map 加两个城市 多个
		Map<Integer, Map> provinceMap = new HashMap<Integer, Map>();
		provinceMap.put(0, cityMap);
		provinceMap.put(1, cityMap);

		// 国家map  多个
		Map<Integer, Map> countryMap = new HashMap<Integer, Map>();
		provinceMap.put(0, provinceMap);

		System.out.println("你好 色彩  ");
	}

}
