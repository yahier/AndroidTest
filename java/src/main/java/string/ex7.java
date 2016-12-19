package string;

public class ex7 {
	public static void main(String args[]) {
		String E1 = "[\u4e00-\u9fa5]";//汉字
		String E2 = "[a-zA-Z]";
		String E3="[0-9*]"; //
		int countH = 0;
		StringBuffer buff = new StringBuffer();
		String str = "今天是2012年3月，我的表弟5岁了";
		char[] arrChar = str.toCharArray();
		String[] arrStr = new String[arrChar.length];
		for (int i = 0; i < arrChar.length; i++) {
			arrStr[i] = String.valueOf(arrChar[i]);
		}
		for (String i : arrStr) {
			if (i.matches(E3)) {
				buff.append(i+" ");
			}
		}
		System.out.println(buff);
	}
}
