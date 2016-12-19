package interview;

public class Huizhi2 {

	class Inner {
		void test() {
			System.out.println("inner test");
		}
	}

	public static void main(String[] args) {
		Huizhi2 out = new Huizhi2();
		Inner in = out.new Inner();
		in.test();
	}

}
