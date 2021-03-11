package string;

public class Index_Sub {
	public static void main(String[] args) {
		System.out.println(replaceString("weibo_yahie"));
		// System.out.println(replaceString("QQ_yahie"));
		// System.out.println(replaceString("yahie"));
	}

	static String replaceString(String text) {
		if (!text.contains("QQ_") && !text.contains("weibo_")) {
			return text;
		} else {
			int index = text.indexOf("�ظ�");
			System.out.println(index);
			String userId = text.substring(0, index);
			userId = "ziwang";
			text = userId.concat(text.substring(index));
		}
		return text;
	}

}
