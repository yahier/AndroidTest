package javadata;

import java.util.Arrays;


public class Sort2 {
	static int[] a={3,2,5,1};
	public static void main(String[] args) {
		Sort2 so = new Sort2();
		so.binarySort(a);
	}
	
	void shellSort(int[] a){
		
		
	}
	
	void binarySort(int[] a){
		int index = 0;
		for(int i=1;i<a.length;i++){
			if(a[i]<a[index]){
				int tem = a[i];
				a[i]=a[index];
				a[index]=tem;
				index=i;
			}
		}
		
		System.out.println(Arrays.toString(a));
		
	}
	

}
