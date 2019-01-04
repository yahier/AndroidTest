package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yahier on 17/8/18.
 */

public class TestSplit {

    public final static void main(String[] args) {
        String content = "yhhjbbkvnvdsfdlknjvnjkdfnjkfjknfbdnbdfnjkfdbjnkdfbnjkfbdkjnbkjnfbdnjkfdbkjfdb";
        String[] arrays = split(content, "y");
        for (String str : arrays) {
            System.out.println("content:" + str);
        }

        System.out.println();

        arrays = content.split("y");
        for (String str : arrays) {
            System.out.println("content:" + str);
        }
        //和系统JDK  比较一下速度
//        long time1 = System.currentTimeMillis();
//        for (int i = 0, a = 1; i < 100000; i++) {
//            split(content, "b");
//        }
//        long time2 = System.currentTimeMillis();
//        System.out.println("time:" + (time2 - time1));
//
//
//        time1 = System.currentTimeMillis();
//        for (int i = 0; i < 100000; i++) {
//            content.split("b");
//        }
//        time2 = System.currentTimeMillis();
//        System.out.println("time:" + (time2 - time1));


    }

    /**
     * split(regex,limit)第二个参数如果是负数或者0，则次数尽可能的多,如果是正数，则被应用的测试是limit-1
     * split(regex) = split(regex,0)
     */
    private static void test1() {
        String a = "aooboocoodoof";
        String[] data = a.split("oo", 0);
        System.out.println(data.length + "   " + Arrays.toString(data));

        System.out.println();

        {
            //limit-1.所以这里完全不起效果
            String[] data2 = a.split("oo", 1);
            System.out.println(data2.length + "   " + Arrays.toString(data2));
        }
    }


    //实现split方法.不理解的是:大多数情况下:这个方法的运行效率竟然比jdk的split方法还要快
    static String[] split(String content, String split) {
        List<String> list = new ArrayList<>();
        int index;
        while ((index = content.indexOf(split)) >= 0) {
            list.add(content.substring(0, index));
            content = content.substring(index + split.length());
        }
        //最后的尾巴
        if (!content.equals(""))
            list.add(content);
        return list.toArray(new String[list.size()]);
    }


}
