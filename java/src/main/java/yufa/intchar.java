package yufa;

public class intchar {
	public static void main(String[] args) {
		t();
	}

	//测试下 int与char的转换
	static void t() {
		int a = 49;
		char c='a';
		char ch = (char) a;
		int b=c;
		System.out.println(ch);
		if(a==c){
			System.out.print(1234);
		}
	}
}
