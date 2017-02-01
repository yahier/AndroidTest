package classic;

public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   new Triangle().judge(8,5,1);
}
	 
	 public void judge(int a,int b,int c){
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
