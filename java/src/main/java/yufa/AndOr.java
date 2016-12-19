package yufa;

public class AndOr {
	public static void main(String[] args) {
		// System.out.println(AndOr.go());
		// getHashCode();
		//te();
		//System.out.println("长度是   "+args.length);
		int length = args.length;
		for(int i=0;i<length;i++){
			System.out.println("...."+args[i]);
		}
		as();
	}

	static boolean go() {
		int a = 2, b = 3;
		return true && false || true;

	}

	// 测试 |
	static void te() {
		int a = 2, b = 3;
		if ((a | b) > 2) {
			System.out.println(123);
		}
	}

	static void as() {
		int a = -1;
		a=a>>>2;
		System.out.println(a);
		
	}

	static void getHashCode() {
		int a = 5;
		Integer inte = new Integer(a);
		Integer inte2 = new Integer(a);
		System.out.println(inte.hashCode() + "  " + inte2.hashCode());

		String str1 = new String("yahier");
		String str2 = "yahier";
		String str3 = "yahier";
		System.out.println(str1.hashCode() + " " + str2.hashCode() + " "
				+ str3.hashCode());// -738056074
		if (str1 == str2) {
			System.out.println(12);
		}

		if (str2 == str3) {
			System.out.println(23);// 被打印
		}
	}
}
