package string;

public class IsAllChinese {
	public static void main(String[] args) {
		System.out.println(nameIsChinese("序号"));
	}

	static boolean nameIsChinese(String name) {
		boolean isAllCh = true;
		String[] as = name.split("");
		for (int i = 0; i < as.length; i++) {
			boolean isNum = as[i].matches("[[0-9]|[a-z]|[A-Z]]+");
			if (isNum == true) {
				isAllCh = false;
				System.out.println(i);
				break;
			}
		}
		// boolean isNum = name.matches("[[0-9]|[a-z]|[A-Z]]+");
		// +表示1个或多个（如"3"或"225"），*表示0个或多个（[0-9]*）（如""或"1"或"22"），?表示0个或1个([0-9]?)(如""或"7")
		// System.out.println(isNum);
		return isAllCh;
	}

}
