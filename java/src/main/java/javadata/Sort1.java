package javadata;

import java.util.Arrays;
/**���ּ򵥵�����
 * ð�� ѡ�� ����
 */
public class Sort1 {
	static int[] a={2,2,1,1};
	
	public static void main(String[] args) {
		Sort1 s= new Sort1();
		s.bubble2(a);
		
	}
	
	
	/**��ԭ����Ϊ��ð������*/
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
   
	//���ն������д�� ð�� �� 2,2,1,1������������������  �õ� 2 1 1 2
	void bubble2(int[] a){
		for(int i=1;i<a.length;i++){//������ʾ����
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
	/**��Ƶ�е�ð������*/
	void newBubble(int[] a){
		int tem=0;
		for(int i=0;i<a.length-1;i++){
			for(int j =a.length-1;j>i;j--){//�ڶ������������ø�ǰ���ź����  ����Ҫ�ٶ��ˡ�
				if(a[j]<a[j-1]){
					tem=a[j];
					a[j]=a[j-1];
					a[i]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(a));
		
	}
	/**ѡ������  ���δ������� ѡ����С��*/
	void chooseSort(int[] a){
		for(int i=0;i<a.length;i++){
			//�ҳ���С��֮�� ����a[i]����
			int min=a[i];
			for(int j=i;j<a.length;j++){
				if(a[j]<min){
					int tem = a[j];
					a[j]=min;
					min=tem;
				}
			}
			//ʣ����С������a[i]����
			int t = min;
			min=a[i];
			a[i]=t;
		}
		
		System.out.println(Arrays.toString(a));
		
	}
	
	/**��������  ��֤ǰ��һֱ���ź����*/
	void insertSort(int[] a){
		for(int i=1;i<a.length;i++){
			//��С����  ��Ϊ��Ҫ��ǰ�� ����Ƚ�
			for(int j=0;j<i;j++){
				if(a[i]<a[j]){//
					//����
					//System.out.println("������������    "+a[i]+"   "+a[j]);
					int tem = a[i];
					a[i]=a[j];
					a[j]=tem;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}
}
