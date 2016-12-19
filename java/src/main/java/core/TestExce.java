package core;

public class TestExce {
	public static void main(String[] args) {
		method();
	}

	static void method() {
		int[] a = {};
		try {
			a[0] = a[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(2);
		} finally {
			try {
				throw new MyExce();
			} catch (MyExce e) {
				System.out.println(7);
			}
			System.out.println(3);
		}

	}

}

class MyExce extends Exception {
	public MyExce() {
		// TODO Auto-generated constructor stub
		System.out.println("4");
	}
}
