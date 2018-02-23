package collection;

import java.util.HashMap;
import java.util.Map;

public class MapGet {
	static Map<Integer,String> map=new HashMap<Integer,String>();
    public static void main(String[] args) {
		map.put(1,"yahier");
		System.out.println(map.get(0));
	}
}
