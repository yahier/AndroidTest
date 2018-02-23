package grammer;

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
		//test2();
		//test3();
	}

	/** 测试HashMap */
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
			System.out.println("test:"+it.next());
		}

		System.out.println();
	}

	/** 测试LinkedHashMap */
	static void test2() {
		LinkedHashMap map = new LinkedHashMap(10);
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		map.put("4", "4");

		Set<?> set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println("test2:"+it.next());
		}
		System.out.println();

	}

	/**
	 * 测试TreeMap.会自动根据key排序
	 */
	static void test3() {
		Map map = new TreeMap();
		map.put("Q", "Level Q");
		map.put("4", "Level 2");
		map.put("3", "Level 3");
		map.put("F", "Level F");
		Iterator it = map.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("test3 Key: " + e.getKey()+"-"+e.getValue());

		}
	}

}
