package javadata;

import java.util.Arrays;

/**
 * ��������
 * ϣ������
 * ���ַ�����
 * @author lenovo
 *
 */
public class Sort2 {
	static int[] a={3,2,5,1};
	public static void main(String[] args) {
		Sort2 so = new Sort2();
		so.binarySort(a);
	}
	
	/**ϣ��������ʵҲ�ǲ�������ֻ�ǿ�ʼʱ �Ӵ��˼��*/
	void shellSort(int[] a){
		
		
	}
	
	/**���Զ��ַ�����    �Ƚ�������λ�� �����ұߣ�С�Ķ������*/
	void binarySort(int[] a){
		int index = 0;//�������� ������С�� ������ߣ���ķ����ұߡ�
		for(int i=1;i<a.length;i++){
			if(a[i]<a[index]){
				System.out.println("������������  "+a[i]+"  "+a[index]);
				//��a[i]������ߣ����ǽ�������     �ҵ�ɾ��Ԫ���ٲ���Ԫ�صķ���  ̫������
				int tem = a[i];
				a[i]=a[index];
				a[index]=tem;
				index=i;
			}
		}
		
		System.out.println(Arrays.toString(a));
		
	}
	

}
