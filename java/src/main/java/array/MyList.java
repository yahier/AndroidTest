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

		// ����map  ���
		Map<Integer, String> cityMap = new HashMap<Integer, String>();
		cityMap.put(1, "�麣");
		cityMap.put(3, "����");

		// ʡ��map ���������� ���
		Map<Integer, Map> provinceMap = new HashMap<Integer, Map>();
		provinceMap.put(0, cityMap);
		provinceMap.put(1, cityMap);

		// ����map  ���
		Map<Integer, Map> countryMap = new HashMap<Integer, Map>();
		provinceMap.put(0, provinceMap);

		System.out.println("��� ɫ��  ");
	}

}
