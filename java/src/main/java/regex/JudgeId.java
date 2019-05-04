package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lenovo
 */
public class JudgeId {
    public static void main(String[] args) {
        System.out.println("是否身份证:" + isFitId("4211811989120535"));
        isEnglishNameOrPinyin("4");
        test3();
    }

    /**
     * 是否符合身份证
     */
    static boolean isFitId(String id) {
        String regex = "\\d{15,17}\\w{1}";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(id);
        boolean b = m.matches();
        return b;
    }


    /**
     * 是否是英文名或者拼音
     */
    static void isEnglishNameOrPinyin(String str) {
        String regex = "\\d";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        boolean result1 = m.matches();
        boolean result2 = str.matches(regex);
        System.out.println("英文名匹配:" + result1 + " " + result2);
    }

    /**
     * 是否是英文名或者拼音
     */
    static void test3() {
        String str = "2";
        String regex = "\\d";
        boolean result = str.matches(regex);

        String str2 = "yyyw8fss";
        boolean result2 = str2.matches("^[a-zA-Z]{1,}/?\\d[a-zA-Z]{1,}$");
        System.out.println("test3:" + result + " " + result2);

    }
}
