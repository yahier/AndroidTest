package algorithm;

public class BinarySearch {
	public static void main(String[] args) {
		 int[] data = { 0, 1, 2, 4, 6, 8, 9 };
		 int index = binarySearch(3, data);
		 System.out.println(index);

		//int srcArray[] = { 3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81,95, 101 }; // 15个数
		//System.out.println(binSearch(srcArray, 0, srcArray.length - 1, 81));
	}

	static int binarySearch(int value, int[] data) {
		
		int smallIndex = 0;
		int bigIndex = data.length;
		System.out.println("123 " + data[(smallIndex + bigIndex) / 2]);
		while (data[(smallIndex + bigIndex) / 2] > value) {
			System.out.println(111);
			bigIndex = (smallIndex + bigIndex) / 2;
			if (data[(smallIndex + bigIndex) / 2] == value)
				return (smallIndex + bigIndex) / 2;
		}
		
/*		while (data[(smallIndex + bigIndex) / 2] < value) {
			System.out.println(222);
			smallIndex = (smallIndex + bigIndex) / 2;
			if (data[(smallIndex + bigIndex) / 2] == value)
				return (smallIndex + bigIndex) / 2;
		}*/
		return -1;
	}

	int binary(int value, int[] data) {
		return -1;
	}

	//回调的做法
	public static int binSearch(int srcArray[], int start, int end, int value) {
		//int mid = (end - start) / 2 + start;
		int mid = (end + start) / 2 ;
		
		if (srcArray[mid] == value) {
			return mid;
		}
		if (start >= end) {
			return -1;
			
		} else if (value > srcArray[mid]) {
			return binSearch(srcArray, mid + 1, end, value);
		} else if (value < srcArray[mid]) {
			return binSearch(srcArray, start, mid - 1, value);
		}
		return -1;
	}

}
