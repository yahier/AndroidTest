package javadata;

import java.util.Arrays;

/**
 * 快速排序
 * 希尔排序
 * 二分法排序
 * @author lenovo
 *
 */
public class Sort2 {
	static int[] a={3,2,5,1};
	public static void main(String[] args) {
		Sort2 so = new Sort2();
		so.binarySort(a);
	}
	
	/**希尔排序其实也是插入排序，只是开始时 加大了间隔*/
	void shellSort(int[] a){
		
		
	}
	
	/**测试二分法排序    先将大于首位的 都放右边，小的都放左边*/
	void binarySort(int[] a){
		int index = 0;//将数组中 比它的小的 放在左边，大的放在右边。
		for(int i=1;i<a.length;i++){
			if(a[i]<a[index]){
				System.out.println("交换的数据是  "+a[i]+"  "+a[index]);
				//把a[i]移至左边，不是交换数据     我的删除元素再插入元素的方法  太复杂了
				int tem = a[i];
				a[i]=a[index];
				a[index]=tem;
				index=i;
			}
		}
		
		System.out.println(Arrays.toString(a));
		
	}
	

}
