package string;

public class Getchars {
	public static void main(String args[]){
	      char c[],d[];
	      String s="巴西足球队击败德国足球队";
	      c=new char[5];
	      s.getChars(5,7,c,2);//参数分别是起始索引 结尾索引 目标数组 偏移量（数组前面为空的数量）
	      System.out.println(c);
	      d=new char[s.length()];
	      s.getChars(7,12,d,0);
	      s.getChars(5,7,d,5);
	      s.getChars(0,5,d,7);
	      System.out.println(d);
	   }
}


//主要是体验String的getChars(....)方法