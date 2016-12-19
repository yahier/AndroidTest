package javadata;

import java.util.Comparator;
import java.util.TreeMap;

public class Test {

	public static void main(String[] args) {
		TreeMap<String, String> treeMap1 = new TreeMap<String, String>();
		treeMap1.put("2", "1");
		treeMap1.put("b", "1");
		treeMap1.put("1", "1");
		treeMap1.put("a", "1");
		System.out.println("treeMap1=" + treeMap1);

		//TreeMap如不指定排序器，默认将按照key值进行升序排序，如果指定了排序器，则按照指定的排序器进行排序。
		TreeMap<String, String> treeMap2 = new TreeMap<String, String>(
				new Comparator<String>() {
					public int compare(String o1, String o2) {
						return o2.compareTo(o1);
					}
				});
		treeMap2.put("2", "1");
		treeMap2.put("b", "1");
		treeMap2.put("1", "1");
		treeMap2.put("a", "1");
		System.out.println("treeMap2=" + treeMap2);
	}
}
