package java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by yahier on 2018/1/22.
 * 测试api 新的日期和时间
 */

public class TimeTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        practice1();
        practice4();
    }

    //时间线Instant 和时间间隔 Duration
    static void test1() {
        Instant instant = Instant.now();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Instant instant2 = Instant.now();

        Duration duration = Duration.between(instant, instant2);
        println("test1", duration.getSeconds() + "");
        Duration duration2 = duration.multipliedBy(10);
        println("test1", duration2.getSeconds() + "");
    }

    //本地日期 LocalDate
    static void test2() {
        LocalDate dateNow = LocalDate.now();
        LocalDate date = LocalDate.of(2018, 1, 1);
        date = date.plusDays(100);
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        int weekDay = date.getDayOfWeek().getValue();//星期一调用 返回1
        println("test2", year + "-" + month + "-" + day + " 星期" + weekDay);

        if (date.isBefore(dateNow)) {
            println("test2", "date.isBefore(dateNow)");
        }
    }

    //本地时间 LocalTime
    static void test3() {
        LocalTime time = LocalTime.of(8, 0);
        //LocalTime time = LocalTime.now();
        int hour = time.getHour();
        int minutes = time.getMinute();
        int second = time.getSecond();
        println("test3", hour + ":" + minutes + ":" + second);
    }

    //ZonedDateTime
    static void test4() {
        ZonedDateTime dateTime = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), ZoneId.of("Asia/Shanghai"));
        int year = dateTime.getYear();
        int month = dateTime.getMonthValue();
        int day = dateTime.getDayOfMonth();
        int hour = dateTime.getHour();
        int minutes = dateTime.getMinute();

        println("test4", year + "-" + month + "-" + day + " " + hour + ":" + minutes);
    }


    //格式化日期
    static void test5() {
        //DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE;//2018-01-23
        //DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;//2018-01-23
        //DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_TIME;//09:09:24.254
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//2018-01-23 09:12:05
        LocalDateTime dateTime = LocalDateTime.now();
        String format1 = dateTime.format(formatter);
        println("test5", format1);

        //将格式化的String还原回日期
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime localDateTime = LocalDateTime.parse("2018-01-23 15:02", formatter2);
        println("test5", "hour:" + localDateTime.getHour());

        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy MM dd");
        LocalDate date = LocalDate.parse("2017 06 17", formatter3);
        println("test5", "date:" + formatter3.format(date));
    }

    //与旧有类交互
    static void test6() {
        Date date = new Date();
        Instant instant = date.toInstant();

        Calendar calendar = Calendar.getInstance();
        Date date2 = calendar.getTime();

        println("test6", date.getTime() + ":" + date2.getTime());

        LocalDate localDate = LocalDate.now();
        //date calendar怎么与LocalDate LocalTime转换是不知道了。
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("Asia/Shanghai"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");//2018-01-23 09:12:05

        String formatTime2 = zonedDateTime.format(formatter);
        println("test6", formatTime2);
    }


    //计算今年的程序员节的日期(每年的第256天
    static void practice1() {
        LocalDate date = LocalDate.of(2018, 1, 1);
        date = date.plusDays(255);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        println("practice1", date.format(formatter));

        //不使用plus方法的话

    }

    //计算活了多少天
    static void practice4() {
        LocalDate dateNow = LocalDate.now();
        LocalDate dateBirth = LocalDate.of(1990, 1, 11);
        Period period = Period.between(dateBirth, dateNow);
        int years = period.getYears();
        int months = period.getMonths();
        int days = period.getDays();
        println("practice4", years + "," + months + "," + days);
        //以上的算法太麻烦了

        //最简单的计算
        long daysDiff = ChronoUnit.DAYS.between(dateBirth, dateNow);
        println("practice4", "daysDiff: " + daysDiff);//good

        LocalTime time1 = LocalTime.of(14, 5);
        LocalTime time2 = LocalTime.of(16, 23);
        long timeDiff = ChronoUnit.MINUTES.between(time1, time2);
        println("practice4", "timeDiff: " + timeDiff);//good

    }

    private static void println(String tag, String value) {
        System.out.println(tag + "," + value);
        System.out.println();
    }


}
