package com.yahier.androidtest.util.apache;

import android.util.Log;

import com.annimon.stream.Stream;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by yahier on 10/1/18.
 */

public class LangTest {
    public static void main() {
        test1();
        test2();
        test3();
        test4();
        test5();
    }

    /**
     * StringUtils
     */
    private static void test1() {
        String[] names = {"huahua", "bingo", "flow"};
        String result = StringUtils.join(names, "-");//连接
        Log.d("result", "result:" + result);
    }

    /**
     * ArrayUtils数组工具类
     */
    private static void test2() {
        String[] names = {"huahua", "bingo", "flow"};
        String[] arrays = ArrayUtils.addAll(names, "张三");//扩充数组
        Stream.of(arrays).forEach(item -> Log.d("test2", item));
    }

    /**
     * RandomUtils
     */
    private static void test3() {
        int a = RandomUtils.nextInt(0, 10); //[0,10);
        String str = RandomStringUtils.random(3, "UTF-8");//生成3个字母的字符串
        Log.d("test3", a + "  " + str);

        //以上是伪随机，要求严格的话，尽量shi'y使用SecureRandom
    }

    /**
     * 时间转换 和 时间格式化 DateUtils DateFormatUtils
     */
    private static void test4() {
        Date date1 = DateUtils.addHours(new Date(), 3);

        Date date = DateUtils.truncate(new Date(), Calendar.HOUR);

        String formattedTime = DateFormatUtils.format(new Date(), "yyyyMMdd HH:ss:mm");

        Log.d("test4", "  " + formattedTime);
    }

    /**
     * 封装返回值是2个或者3个的场景
     */
    private static void test5() {
        User user1 = new User();
        user1.setName("yahier");

        User user2 = new User();
        user2.setName("daiyang");

        ImmutablePair pair = ImmutablePair.of(user1, user2); //还有一个 ImmutableTriple
        String name1 = ((User) pair.getLeft()).getName();
        String name2 = ((User) pair.getRight()).getName();
        Log.d("test5", name1 + ":" + name2);


    }
}

