package core;

public class Kuai {
	static int a = 1;

	public static void main(String[] args) {
		System.out.println("我是main");
		Kuai kuai = new Kuai();
		// String[] a = {"1","2","3"};
		Integer[] b = { 1, 2, 3 };
		kuai.ya(b);
	}

	void test() {
		{
			System.out.println(a);
		}
		{
			System.out.println(++a);
		}
		{
			System.out.println(123);
		}

	}

	static {
		a++;
		System.out.println("我是静态代码块");
	}

	String to(String... strings) {
		String str = strings[2];
		System.out.println(str);
		return str;
	}

	Integer ya(Integer... a) {
		try {
			System.out.println(a[0]);
		} finally {
            
		}
		return a[0];
	}
}
