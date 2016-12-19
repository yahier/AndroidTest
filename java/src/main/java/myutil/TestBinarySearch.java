package myutil;

import java.util.Arrays;



public class TestBinarySearch {
	static int[] data = { 2, 3, 4, 5, 6, 7, 8, 9 };
	static String[] data2 = { "12", "13", "14", "15", "16", "17", "18", "19" };

	public static void main(String[] args) {
		search();
		search2();
	}

	static void search() {
		int index = Arrays.binarySearch(data, 33);
		System.out.println(index);
	}

	static void search2() {
		int index = Arrays.binarySearch(data2, "14");
		System.out.println(index);
	}
}
