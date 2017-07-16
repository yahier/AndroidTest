package myutil;

/**
 * Created by yahier on 17/3/28.
 */

public class Log {

    public static void e(String tag, String content) {
        System.out.println(tag + ":" + content);
    }

    public static void e(String tag, boolean content) {
        System.out.println(tag + ":" + content);
    }
}
