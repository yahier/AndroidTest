package array;

import java.util.Arrays;

public class ReverseArray {
	static int[] data = { 1, 2 };

	public static void main(String[] args) {
		ReverseArray re = new ReverseArray();
		//re.reverse(data);
		re.init();


	}
	
	void init(){
		int[][] a = new int[][]{{1},{1,2},{1,3,3,1}};
		System.out.println("a.length is "+a.length);
		for(int i=0;i<a.length;i++){
			System.out.println(Arrays.toString(a[i]));
			System.out.println(a[i].length);
		}
	}

	void reverse(int[] a) {
		for (int i = 0; i < a.length / 2; i++) {
			exchange(i);
		}
		// System.out.println(Arrays.toString(a));
	}

	void exchange(int index) {
		int tem = data[index];
		data[index] = data[data.length - 1 - index];
		data[data.length - 1 - index] = tem;
	}



	void digui1(int n) {
		if (n < 500)
			digui1(n * 2);
		else
			System.out.println(n);
	}

}
