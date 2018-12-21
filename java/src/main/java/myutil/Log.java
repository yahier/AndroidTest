package myutil;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

    public static void addPreDate(String tag, String content) {
        DateFormat dateFormat = new SimpleDateFormat("mm:ss");
        String strDate = dateFormat.format(new Date());
        System.out.println(strDate + " " + tag + ":" + content);
    }
}
