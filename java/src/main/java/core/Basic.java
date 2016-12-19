package core;

public class Basic {
	public static void main(String[] args) {
		mu();
		System.out.println(isOdd(-3));
		int a = And.b;
	}

	static void mu() {
		System.out.println(2.00 - 1.10);// 0.89999
	}

	static boolean isOdd(int a) {
		System.out.println(-3%2);
		return a % 2 == 1;
		
	}
}
