package core;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class Fanxing {

	//测试 转换
	void as() {
		List<?> listOfAnyType;
		List<Object> listOfObject = new ArrayList<Object>();
		List<String> listOfString = new ArrayList<String>();
		List<Integer> listOfInteger = new ArrayList<Integer>();

		listOfAnyType = listOfString; 
		listOfAnyType = listOfInteger; 
		listOfObject.add("");
		//listOfObject = (List<Object>) listOfString; // compiler error -
		
		String a = "1";
		Object b =a;
														
	}
	
	void s(){
		LinkedHashMap a = new LinkedHashMap();
		
	}
}
