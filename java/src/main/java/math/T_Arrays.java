package math;

import java.util.Arrays;

public class T_Arrays {
	//������  �ҵķ��������  ˥
  static int[] a={11,25,6,5,9,7,4,12,58,8};
  static int mid;
    public static void main(String[] args){
    	int small=T_Arrays.pickS();
    	int big=T_Arrays.pickB();
    	int[] b={11,25,6,5,9,7,4,12,58,8};
    	//static int[] a={11,25,6,5,9,7,4,12,58,8}; 
       mid=b[0];
	   b[0]=small;
	   small=mid; //������һ�������
	   
	   mid=b[0];
	   b[0]=big;
	   big=mid;  //�������һ������С
	   
	 for(int i=0;i<a.length;i++){
		 System.out.println(b[i]);
	 }
	   
    }  	   
	   
   public static int pickS(){
	  Arrays.sort(a);
	  return a[0];
	  
   }
   
   public static int pickB(){
	   Arrays.sort(a);
	   return a[9];
	   
   }
   
   //��Ҫ��ѡ ����Ҫ����  ��
   
   public void ya(){
	   for(int i=0;i<a.length;i++){
		   for(int j=i;j<a.length;j++){
			   
		   }
	   }
   }
   
  
}










