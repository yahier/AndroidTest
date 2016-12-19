package math;

import java.util.Scanner;

public class Accu {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int eng=0;//Ӣ����ĸ
		int num=0;//����
		int spa=0;//�ո��
		int oth=0;//�����ַ��
	
		//�ؼ����ڲ�֪������ ��ո��unicode����
		// TODO Auto-generated method stub
      Scanner scan=new Scanner(System.in);
      String s=scan.nextLine();
      String str="d";//��������d��ʾ
      while(s.matches(str)){
    	  num++;
      }                    //������ʽû����Ч
      
      byte[] b=s.getBytes();  //��ת�����ַ�����
      for(int i=0;i<b.length;i++){
    	 if(b[i]>65&&b[i]<90||b[i]>=97&&b[i]<=122) eng++; //��ĸ����unicode���  ����������ʽ����
    	 if(b[i]>='0'&&b[i]<='9')                  num++;  
    	 if(b[i]==' ')                             spa++;  
      }
      
      oth=s.length()-eng-num-spa;                          
      
      
      System.out.println(eng+"  "+num+" "+spa+" "+oth);
      //System.out.println(Integer.parseInt("��"));  ������
      
	}

}
