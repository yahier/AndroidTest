package date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateTest {
    public static void main(String[] args) {

        test();

    }

    static void test() {
        String pattern = "yyyy-MM-dd";
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(-1003086828933L);
        Date date = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        // SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        System.out.printf("date:" + format.format(date));


    }

    static void sa() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date d = new Date();
        String date_s = sdf.format(d);
        System.out.println(date_s);
    }

    static void te2() {
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy",
                Locale.ENGLISH);

        Date d = null;
        try {
            d = sdf.parse("Wed Jan 03 00:00:00 1900");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(new SimpleDateFormat("yyyy-MM-dd").format(d));
    }
}
