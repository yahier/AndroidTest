package algorithm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 有一个数组，不断加入新的数据 返回数组中最开始的与这个相同元素的index, <br>
 * 没有就返回-1，并将这个元素加入其中
 * 
 * @author lenovo
 * 
 */
public class IsContained {
	List myList = new ArrayList();
	static IsContained ic;
	static Object[] arrs = { 1, 2, "bingo", 4, 5, 4, 5 };

	public static void main(String[] args) {
		ic = new IsContained();
		ic.initi();
		// 测试成功。
		for (int i = 0; i < arrs.length; i++) {
			System.out.println(ic.isContained(arrs[i]));

		}

	}

	/**
	 * 初始化一些数据
	 */
	void initi() {
		myList.add(2);
		myList.add("bingo");
		myList.add(ic);

	}

	int isContained(Object a) {
		int index = 0;
		Iterator i = myList.iterator();
		while (i.hasNext()) {
			if (a == i.next())
				return index;
			index++;
		}
		myList.add(a);
		return -1;
	}

}
