package javadata;

import java.util.Arrays;

public class Sort1 {
	static int[] a={2,2,1,1};
	
	public static void main(String[] args) {
		Sort1 s= new Sort1();
		s.bubble2(a);
		
	}
	
	
	void bubble(int[] a){
		for(int i=0;i<a.length;i++){
			for(int j=i;j<a.length;j++){
				if(a[i]>a[j]){
					int tem = a[i];
					a[i]=a[j];
					a[j]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
   
	void bubble2(int[] a){
		for(int i=1;i<a.length;i++){
			for(int j=1;j<a.length;j++){
				if(a[j]<=a[j-1]){
					int tem = a[j];
					a[j]=a[j-1];
					a[j-1]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
	void newBubble(int[] a){
		int tem=0;
		for(int i=0;i<a.length-1;i++){
			for(int j =a.length-1;j>i;j--){
				if(a[j]<a[j-1]){
					tem=a[j];
					a[j]=a[j-1];
					a[i]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(a));
		
	}
	void chooseSort(int[] a){
		for(int i=0;i<a.length;i++){
			int min=a[i];
			for(int j=i;j<a.length;j++){
				if(a[j]<min){
					int tem = a[j];
					a[j]=min;
					min=tem;
				}
			}
			int t = min;
			min=a[i];
			a[i]=t;
		}
		
		System.out.println(Arrays.toString(a));
		
	}
	
	void insertSort(int[] a){
		for(int i=1;i<a.length;i++){
			for(int j=0;j<i;j++){
				if(a[i]<a[j]){//
					int tem = a[i];
					a[i]=a[j];
					a[j]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
