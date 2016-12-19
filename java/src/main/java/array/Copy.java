package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

//测试下 数组控制
public class Copy {
	int[] a = { 1, 2, 3, 4, 5 };

	public static void main(String[] args) {
		Copy copy = new Copy();
		copy.test();
	}

	public void test() {
		int[] b = new int[5];
		System.arraycopy(a, 2, b, 2, 3);

		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

	}

	void test1() {
		int[] b = new int[3];
		System.arraycopy(a, 1, b, 1, 2);
		System.out.println(Arrays.toString(b));

	}

	void test2() {
		char a = 'a', b = 'a';
		System.out.println(a + 1);
		if (a == b) {
			System.out.println(123);
		}

	}

	void test3() {
		for (int i = 0; i < 3; i++) {

		}

		List list = new ArrayList();
		for (Iterator it = list.iterator(); it.hasNext();) {

		}
	}

	void test4() {
		String a = "boo:and:foo";
		String[] data = a.split("[o]", -1);
		System.out.println(data.length + "   " + Arrays.toString(data));
	}

	// 以下测试 TreeMap失败
	class Stu implements Comparable {
		public Stu(String name, int score) {

		}

		@Override
		public int compareTo(Object another) {
			// TODO Auto-generated method stub
			return 0;
		}
	}

	class StuIn {
		public StuIn(Stu s) {

		}
	}

	void test5() {
		TreeMap map = new TreeMap();
		Stu a1 = new Stu("a", 12);
		Stu a2 = new Stu("b", 1);
		Stu a3 = new Stu("c", 3);
		Stu a4 = new Stu("d", 4);
		Stu a5 = new Stu("e", 8);
		Stu a6 = new Stu("f", 2);
		Stu a7 = new Stu("g", 5);

		map.put(a1, new StuIn(a1));
		map.put(a2, new StuIn(a2));
		map.put(a3, new StuIn(a3));
		map.put(a4, new StuIn(a4));
		map.put(a5, new StuIn(a5));
		map.put(a6, new StuIn(a6));
		map.put(a7, new StuIn(a7));

		map = (TreeMap) map.subMap(a2, a6);
		Set set = map.keySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {
			System.out.println("  " + map.get(it.next()));
		}

	}

}
