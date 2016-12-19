package string;

public class Jinzhi {
	static int a = 0x12;
	public static void main(String[] args) {
		System.out.println(a++);
		System.out.println(a);
		String a = Integer.toBinaryString(12);
		System.out.println(a);
		String b = Integer.toHexString(12);
		System.out.println("b is "+b);
	}

}
