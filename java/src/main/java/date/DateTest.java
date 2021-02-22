package date;

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
        SimpleDateFormat format;
        String dateFormat;
        {
            String pattern = "yyyy-MM-dd";
            Calendar calendar = Calendar.getInstance();
            Date date = calendar.getTime();
            format = new SimpleDateFormat(pattern, Locale.CHINESE);
            dateFormat = format.format(date);
            System.err.println("日期是:" + dateFormat);//2021-01-07
        }


        //将格式化日期转成时间戳
        try {
            Date newDate = format.parse(dateFormat);
            String pattern2 = "yyyy-MM-dd HH:mm:ss";
            SimpleDateFormat format2 = new SimpleDateFormat(pattern2, Locale.CHINESE);
            String dateFormat2 = format2.format(newDate);
            System.err.println("新日期是:" + dateFormat2);//2021-01-07 00:00:00
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    static void sa() {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.getDefault());
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
