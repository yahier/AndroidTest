package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsAllChinese {
    public static void main(String[] args) {
        testStrDelete();
        //System.out.println(nameIsChinese("序号"));
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


    static void testStrDelete() {
        String origin = "a\n\n\nb\nc\n";
        System.out.println("origin:");
        System.out.println(origin);
        System.out.println("end");


        Pattern pattern = Pattern.compile("[\\n]{2,}");
        Matcher matcher = pattern.matcher(origin);
        String old = matcher.replaceAll("\n");
        if (old.endsWith("\n")) {
            int indexEndChangeLine = old.lastIndexOf("\n");
            old = old.substring(0, indexEndChangeLine);
        }
        System.out.println("old:");
        System.out.println(old);
        System.out.println("end");


    }

}
