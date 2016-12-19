package string;

public class Index_Sub {
	public static void main(String[] args) {
		System.out.println(replaceString("weibo_yahier回复栏里你"));
		// System.out.println(replaceString("QQ_yahier回复了栏里你"));
		// System.out.println(replaceString("yahier回复了栏里你"));
	}

	static String replaceString(String text) {
		if (!text.contains("QQ_") && !text.contains("weibo_")) {
			return text;
		} else {
			int index = text.indexOf("回复");
			System.out.println(index);
			String userId = text.substring(0, index);
			userId = "ziwang";
			text = userId.concat(text.substring(index));
		}
		return text;
	}

}
