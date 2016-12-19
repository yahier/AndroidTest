package core;

/**
 * 测试继承 没错 将变量也继承来了
 * 
 * @author lenovo
 * 
 */
public class Sub extends A {
	public static void main(String[] args) {
		System.out.println(a);
	}

}

class A {
	static int a = 2;
}