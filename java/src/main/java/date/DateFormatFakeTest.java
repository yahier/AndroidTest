package date;

/**
 * Created by yahier on 11/1/18.
 * 测试多线程下的SimpleDateFormat，如果需要重现问题 去掉同步方案即可
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 测试SimpleDateFormat在多线程时的问题。
 */
public class DateFormatFakeTest extends Thread {
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private String name;
    private String dateStr;
    private Date date;
    private long sleepTime;
    static DateFormatFakeTest mutex;

    public DateFormatFakeTest() {

    }

    public DateFormatFakeTest(String name, String dateStr, long sleepTime) {
        this.name = name;
        this.dateStr = dateStr;
        this.sleepTime = sleepTime;
    }

    public DateFormatFakeTest(String name, Date date, long sleepTime) {
        this.name = name;
        this.date = date;
        this.sleepTime = sleepTime;
    }

    @Override
    public void run() {
        if (dateStr != null) {
            handleDataStr();
        }

        if (date != null) {
            handleDate();
        }

    }

    private void handleDataStr() {
        Date date = null;
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(name + " : dateStr: " + dateStr);
            // fixme 下一句代码偶尔会出现 java.lang.NumberFormatException: multiple points。加同步之后 问题得以解决
            synchronized (mutex) {
                date = dateFormat.parse(dateStr);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(name + " : date: " + date);
    }


    /**
     * dateFormat.format(Date date)方法在多线程中使用没有问题
     */
    private void handleDate() {
        String dateStr = null;
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(name + " : date: " + date);
            dateStr = dateFormat.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(name + " : dateStr: " + dateStr);
    }

    public static void main(String[] args) throws InterruptedException {
        mutex = new DateFormatFakeTest();
        test1();
        test2();
    }


    private static void test1() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            int sleepTime = new Random().nextInt(3000);
            executor.execute(new DateFormatFakeTest(String.valueOf(i + 1), "1991-12-13", sleepTime));
        }
        executor.shutdown();
    }

    private static void test2() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            int sleepTime = new Random().nextInt(3000);
            executor.execute(new DateFormatFakeTest(String.valueOf(i + 1), new Date(), sleepTime));
        }
        executor.shutdown();
    }
}
