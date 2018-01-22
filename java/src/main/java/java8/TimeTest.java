package java8;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

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


    static void println(String tag, String value) {
        System.out.println(tag + "," + value);
    }


}
