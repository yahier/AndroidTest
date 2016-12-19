package core;

public class N10 {

	public static void main(String[] args) {
		N10 n = new N10();
		//System.out.println(n.get());
		n.t();
	}

	void one() {
		String a = "yahier";
		if (a.equals("a")) {
			// pass
		}
	}

	boolean get() {
		int a = 1;
		return (a == 1) ? true : false;
	}

	void t() {
		int[] a = { 1, 2, 3 };
		try {
			a[3] = 3;
			throw new NullPointerException();
		} catch (ArrayIndexOutOfBoundsException e) {

		}
	}
}
