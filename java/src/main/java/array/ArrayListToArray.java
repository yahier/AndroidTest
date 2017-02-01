package array;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArray {
	public static void main(String[] args) {
		ArrayListToArray  o = new ArrayListToArray();
		o.change();
	}

	void change() {
		ArrayList list = new ArrayList();
		for (int i = 0; i < 8; i++) {
			list.add(i);
		}

		Object[] a1 =  list.toArray();
		String str = Arrays.toString(a1);
		str = str.replace('[', '(');
		str = str.replace(']', ')');
		
		System.out.println(str);
	}

}
