package string;

import myutil.Log;

/**
 * Created by yahier on 17/5/27.
 */

public class StringBufferTest {

    public static final void main(String[] args) {
        //test1();
        //test2();
        //test3();
        //test4();
        test5();
        test6();

    }

    //9
    private static void test1() {
        long time1 = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            buffer.append("我");
            buffer.append("是");
            buffer.append("一");
            buffer.append("滴");
            buffer.append("远");
            buffer.append("方");
            buffer.append("孤");
            buffer.append("星");
            buffer.append("的");
        }

        long time2 = System.currentTimeMillis();
        Log.e("test1", "time:" + (time2 - time1));
    }

    //4
    private static void test2() {
        long time1 = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            buffer.append("我").append("是").append("一").append("滴").append("远").append("方").append("孤").append("星").append("的");
        }

        long time2 = System.currentTimeMillis();
        Log.e("test2", "time:" + (time2 - time1));
    }

    //6
    private static void test3() {
        long time1 = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            buffer.append('我');
            buffer.append('是');
            buffer.append('一');
            buffer.append('滴');
            buffer.append('远');
            buffer.append('方');
            buffer.append('孤');
            buffer.append('星');
            buffer.append('的');
        }

        long time2 = System.currentTimeMillis();
        Log.e("test3", "time:" + (time2 - time1));
    }

    //4
    private static void test4() {
        long time1 = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 10000; i++) {
            buffer.append('我').append('是').append('一').append('滴').append('远').append('方').append('孤').append('星').append('的');
        }

        long time2 = System.currentTimeMillis();
        Log.e("test4", "time:" + (time2 - time1));
    }


    //8
    private static void test5() {
        long time1 = System.currentTimeMillis();
        String str = "yahier is not here";
        for (int i = 0; i < 100000; i++) {
            int a = str.indexOf("h");
        }

        long time2 = System.currentTimeMillis();
        Log.e("test5", "time:" + (time2 - time1));
    }

    //5
    private static void test6() {
        long time1 = System.currentTimeMillis();
        String str = "yahier is not here";
        for (int i = 0; i < 100000; i++) {
            int a = str.indexOf('h');
        }

        long time2 = System.currentTimeMillis();
        Log.e("test6", "time:" + (time2 - time1));
    }

}
