package javacore;

class ya {
	int a = 0;
}

public class Su extends ya {
	public static void main(String[] args) {

		Su s = new Su();
		s.t();
		System.out.println(s.a);

	}

	void t() {
		a = 3;
	}
}
