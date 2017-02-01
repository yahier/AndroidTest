package interview;

/**
 * 测试父类 子类 static和构造函数的执行顺序
 */
public class People extends Monkey {
	public static void main(String[] args) {
		//打印顺序是 3 1 4 2
		 //Monkey monkey = new People();

		System.out.println("1 " + get("1222"));
		//System.out.println("2 " + get("1222.1"));
		//System.out.println("3 " + get("1222.1111"));
		//System.out.println("4 " + get("1222."));

	}

	public static String get(String str) {
		int index = str.indexOf(".");
		if (index == -1)
			return str;
		try {
			str = str.substring(0, index + 2);
		} catch (Exception e) {

		}
		return str;
	}

	static {
		System.out.println("1");
	}

	public People() {
		// TODO Auto-generated constructor stub
		System.out.println("2");
	}

}

class Monkey {
	static {
		System.out.println("3");
	}

	public Monkey() {
		// TODO Auto-generated constructor stub
		System.out.println("4");
	}

}