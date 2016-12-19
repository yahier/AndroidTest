package confused;

public class T {
	public static void main(String[] args) {
		as();
	}
	
	static void t(){
		int a=1,b=1;
		boolean a1=a==2;
		boolean b1=b==1;
		if(a1&&b1){
			System.out.println(123);
		}
		System.out.println(b1);
	}

	static int a=5,b=2;
	static void as(){
		System.out.println(a|=b);
	}
}
