package pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 判断是否符合身份证 15到18位，最后一位可能是字母
 * @author lenovo
 *
 */
public class JudgeId {
	public static void main(String[] args) {
		System.out.println(isFitId("4211811989120535"));
	}
	

	
	static boolean isFitId(String id){
		String regex = "\\d{15,17}\\w{1}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(id);
		boolean b = m.matches();
		return b;
	}
}
