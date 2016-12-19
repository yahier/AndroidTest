package core;

public class Generics<K> {
	public static void main(String[] args) {
		Generics<String> s = new Generics<String>();
		s.test("sd");

	}

	void test(K e) {
		System.out.println(e.toString());

	}

}
