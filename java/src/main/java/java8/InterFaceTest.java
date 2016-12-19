package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class InterFaceTest {
	public static void main(String[] args) {
		testw();
		
	}
	static void testw(){
		List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
		 
		Collections.sort(names, new Comparator<String>() {
		    @Override
		    public int compare(String a, String b) {
		        return a.compareTo(b);
		    }
		}); 
		
		
		String[] array = new String[4];
		names.toArray(array);
		System.out.println(Arrays.toString(array));
	}

}

interface Formula {
	double calculate(int a);

}