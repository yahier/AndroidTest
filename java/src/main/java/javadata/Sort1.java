package javadata;

import java.util.Arrays;
/**三种简单的排序
 * 冒泡 选择 插入
 */
public class Sort1 {
	static int[] a={2,2,1,1};
	
	public static void main(String[] args) {
		Sort1 s= new Sort1();
		s.bubble2(a);
		
	}
	
	
	/**我原本以为的冒泡排序*/
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
   
	//按照定义的重写的 冒泡 对 2,2,1,1这样的数据天生受困  得到 2 1 1 2
	void bubble2(int[] a){
		for(int i=1;i<a.length;i++){//仅仅表示次数
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
	/**视频中的冒泡排序*/
	void newBubble(int[] a){
		int tem=0;
		for(int i=0;i<a.length-1;i++){
			for(int j =a.length-1;j>i;j--){//第二个条件就是让给前面排好序的  不需要再动了。
				if(a[j]<a[j-1]){
					tem=a[j];
					a[j]=a[j-1];
					a[i]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(a));
		
	}
	/**选择排序  依次从数组中 选出最小的*/
	void chooseSort(int[] a){
		for(int i=0;i<a.length;i++){
			//找出最小数之后 会与a[i]交换
			int min=a[i];
			for(int j=i;j<a.length;j++){
				if(a[j]<min){
					int tem = a[j];
					a[j]=min;
					min=tem;
				}
			}
			//剩余最小的数与a[i]交换
			int t = min;
			min=a[i];
			a[i]=t;
		}
		
		System.out.println(Arrays.toString(a));
		
	}
	
	/**插入排序  保证前面一直是排好序的*/
	void insertSort(int[] a){
		for(int i=1;i<a.length;i++){
			//从小到大  因为需要从前面 往后比较
			for(int j=0;j<i;j++){
				if(a[i]<a[j]){//
					//交换
					//System.out.println("交换的数据是    "+a[i]+"   "+a[j]);
					int tem = a[i];
					a[i]=a[j];
					a[j]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
