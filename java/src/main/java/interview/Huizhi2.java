package interview;

/**
 * 测试 内部类
 */
public class Huizhi2 {

	public static void main(String[] args) {
		Huizhi2 out = new Huizhi2();
		Inner in = out.new Inner();
		in.test();
	}

	class Inner {
		void test() {
			System.out.println("inner test");
		}
	}
}
