package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Created by yahier on 2018/1/22.
 */

public class StreamApiTest {
    private static List<String> list = new ArrayList<>();

    static {
        list.add("钟白");
        list.add("路桥川");
        list.add("浩哥");
        list.add("楚连翘");
        list.add("林落雪");
        list.add("钟白");
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }

    static void test1() {
        long count = list.stream().filter(str -> str.length() > 2).count();
        System.out.println("test1:" + count);

        //parallel:并行
        long count2 = list.parallelStream().filter(str -> str.length() > 2).count();
        System.out.println("test1:" + count2);


    }

    //测试数组 转换成Stream
    static void test2() {
        String[] arrays = {"徐子旺", "海飞", "陈桂容", "无双"};
        long count = Stream.of(arrays).filter(str -> str.length() > 2).count();
        System.out.println("test2:" + count);

        long count2 = Stream.of("徐子旺", "海飞", "陈桂容", "无双").count();
        System.out.println("test2:" + count2);

        long count3 = Arrays.stream(arrays, 0, 2).count();
        System.out.println("test2:" + count3);

        //peek返回一个与原Stream相同元素的流。
        //toArray也很重要的函数咯
        Object[] powers = Stream.iterate(1.0, p -> p * 2).peek(e -> System.out.println("e:" + e)).limit(5).toArray();
    }

    //一些特别的Stream的生成 empty generate iterate splitAsStream
    static void test3() {
        Stream stream1 = Stream.empty();
        Stream stream2 = Stream.generate(() -> "yahier");
        Stream<Integer> stream3 = Stream.iterate(1, integer -> integer + 1).limit(5);
        println("test3", stream3);

        Stream stream4 = Pattern.compile("d").splitAsStream("abcdefgsmfddgldjkfdtd");
        println("test3", stream4);

    }


    //测试 map 方法; flatMap
    static void test4() {
        Stream<String> stream1 = list.stream();
        Stream<String> stream2 = stream1.map(str -> "你好呀," + str);
        println("test4", stream2);
    }

    //测试 limit skip concat peek toArray
    static void test5() {
        Stream<String> stream1 = list.stream().limit(3).skip(1);
        Stream<String> stream2 = list.stream().limit(3).skip(1);
        println("test5-1", Stream.concat(stream1, stream2));

        Stream<String> stream3 = list.stream().limit(2);
        Stream stream4 = stream3.peek(str -> System.out.println("test5." + str));

        Object[] objs = stream4.toArray();
        println("test5-2", Stream.of(objs));
    }

    //测试 distinct sorted(这里的参数与MyComparator的方法相同)
    static void test6() {
        Stream<String> stream1 = list.stream().distinct().sorted(Comparator.comparingInt(String::length));
        println("test6", stream1);
    }


    static void println(String tag, Stream stream) {
        stream.forEach(str -> System.out.println(tag + "," + str));
        System.out.println();
    }

    static class MyComparator implements Comparator<String> {

        @Override
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    }
}
