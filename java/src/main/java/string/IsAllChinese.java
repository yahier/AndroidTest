package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsAllChinese {
    public static void main(String[] args) {
        String value = removeRedundantLineTag("123\n4\n\n56\n\n");
        System.out.println("value:" + value + ":");
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


    /**
     * 去除多余的换行符 1.文本前后的换行符都去掉 2.当文本中的换行符有连续大于2个，就只保留2个
     */
    static String removeRedundantLineTag(String origin) {
        if (origin == null) {
            return null;
        }
        origin = origin.trim();
        //中间内容部分，两个以上的换行都替换成2个
        Pattern pattern = Pattern.compile("[\\n]{2,}");
        Matcher matcher = pattern.matcher(origin);
        return matcher.replaceAll("\n\n");
    }

}
