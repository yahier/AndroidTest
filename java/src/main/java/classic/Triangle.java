package classic;

public class Triangle {

	/**
	 * 根据三边大笑 判断是否是三角形
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
   new Triangle().judge(8,5,1);
}
	 
	 public void judge(int a,int b,int c){
		//一个方法是先判断出最大的那个 然后判断较小的两个是否比它大
		//第二个方法是  
		//先实现第一个策略
	if(a>=b){	
		if(a>=c&&b<=c)  System.out.println(a+""+c+""+b+"...1");
		if(a>=c&&b>c)	System.out.println(a+""+b+""+c+"...2");
		if(a<c)	         System.out.println(c+""+b+""+a+"...3");
	}
	else {
		if(a<=c&&b<=c) System.out.println(c+""+b+""+a+"...4");
		if(a<=c&&b>c)  System.out.println(b+""+c+""+a+"...5");
		if(a>c)        System.out.println(b+""+a+""+c+"...6");
	}}

	public void bubble() {
		// TODO Auto-generated method stub
		
	}	
	
	
}
