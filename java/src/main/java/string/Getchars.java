package string;

public class Getchars {
	public static void main(String args[]){
	      char c[],d[];
	      String s="��������ӻ��ܵ¹������";
	      c=new char[5];
	      s.getChars(5,7,c,2);//�����ֱ�����ʼ���� ��β���� Ŀ������ ƫ����������ǰ��Ϊ�յ�������
	      System.out.println(c);
	      d=new char[s.length()];
	      s.getChars(7,12,d,0);
	      s.getChars(5,7,d,5);
	      s.getChars(0,5,d,7);
	      System.out.println(d);
	   }
}


//��Ҫ������String��getChars(....)����