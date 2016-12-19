package myutil;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class TestListIterator {
	public static void main(String[] args) {
		TestListIterator test = new TestListIterator();
		test.test();
	}
	void test() {
		List list = new ArrayList();
		for (int i = 0; i < 9; i++) {
			list.add(i);
		}
		ListIterator<Object> it = list.listIterator();
	
        while(it.hasNext()){
        	System.out.println(it.next());
        }
        
        while(it.hasPrevious()){
        	System.out.println(it.previous());
        }
	}

}
