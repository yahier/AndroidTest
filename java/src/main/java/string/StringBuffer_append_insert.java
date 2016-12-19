package string;

public class StringBuffer_append_insert {
	public static void main(String args[]) {
		StringBuffer str = new StringBuffer("62791720");
		str.insert(0, "010-");// 在索引处插入字符
		str.setCharAt(7, '8'); // 在索引处更换字符
		System.out.println(str);

		str.append("-446");
		System.out.println(str);

		str.reverse();
		System.out.println(str);
	}
}
