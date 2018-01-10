package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lenovo
 */
public class JudgeId {
    public static void main(String[] args) {
        //System.out.println(isFitId("4211811989120535"));
        boolean isEng = isEnglishNameOrPinyin("yyyw//dfss");
        System.out.println("isEng:" + isEng);
    }
    static boolean isFitId(String id) {
        String regex = "\\d{15,17}\\w{1}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(id);
        boolean b = m.matches();
        return b;
    }

    public static boolean isEnglishNameOrPinyin(String str) {
        return str.matches("^[a-zA-Z]{1,}/?[a-zA-Z]{1,}$");
    }
}
