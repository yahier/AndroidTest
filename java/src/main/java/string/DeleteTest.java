package string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by yahier on 17/12/5.
 */

public class DeleteTest {

    public final static void main(String[] args) {
        test1();
        test2();
    }

    static void test1() {
        double v = 0.0;
        int in = (int)v;
        System.err.println("in:"+in);

        String value = "我问发收到234【DX9000】";
        Pattern p = Pattern.compile("【.*】");
        Matcher m = p.matcher(value);
        value = m.replaceAll("");
        System.out.println(value);
    }


    static void test2() {
        String content = "我y飞sd我fdg";
        Pattern p = Pattern.compile("[a-zA-Z]");
        Matcher m = p.matcher(content);
        System.out.println(m.replaceAll("."));
    }
}
