package core;

public class Basic {
	public static void main(String[] args) {
		mu();
		System.out.println(isOdd(-2));
	}

	static void mu() {
		System.out.println(2.00 - 1.10);// 0.89999999999
	}


	static boolean isOdd(int a) {
		return a % 2 == 0;
	}
}
