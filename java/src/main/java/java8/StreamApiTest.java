package java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
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
        String[] arrays = {"徐子旺", "海飞", "石矶娘娘", "无双"};
        long count = Stream.of(arrays).filter(str -> str.length() > 2).count();
        System.out.println("test2:" + count);

        long count2 = Stream.of("徐子旺", "海飞", "石矶娘娘", "无双").count();
        System.out.println("test2:" + count2);

        long count3 = Arrays.stream(arrays, 0, 2).count();
        System.out.println("test2:" + count3);

        //peek返回一个与原Stream相同元素的流。
        //toArray也很重要的函数咯
        Object[] array1 = Stream.iterate(1.0, p -> p * 2).peek(e -> System.out.println("e:" + e)).limit(5).toArray();
        //toArray方法也是可以有参数的
        Integer[] array2 = Stream.iterate(1, p -> p * 2).limit(5).toArray(Integer[]::new);
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

    //测试聚合方法 和 Optional
    static void test7() {
        //除了findFirst外，还有一个findAny.当前测试是同样的结果
        Optional<String> optional = list.stream().filter(str -> str.contains("钟白大哥来了")).findFirst();
        //如有存在数据
        optional.ifPresent(s -> System.out.println("test7," + s));
        //如果不存在数据的情况
        String orElse = optional.orElse("no value 啊");//重新设值
        //String exceptionStr = optional.orElseThrow(NoSuchElementException::new);//异常数据

        //noneMatch 还有anyMatch
        boolean result = list.stream().noneMatch(str -> str.contains("bingo"));
        System.out.println("test7," + result);
    }

    //聚合操作(超厉害) (聚合 元素与顺序无关)  可以做到求和 求积 求列表最大值，列表最小值 追加内容...
    static void test8() {
        //测试求和
        Stream<Integer> stream = Stream.iterate(1, value -> value + 1).limit(5);
        Optional<Integer> result = stream.reduce((a, b) -> a + b);
        result.ifPresent(v -> System.out.println("test8,result:" + v));
        //测试求最大
        int[] array = {1, 5, 77, 3, 68, 9};
        //第一个操作是操作起始值
        int result3 = Arrays.stream(array).reduce(0, (a, b) -> a >= b ? a : b);
        System.out.println("test8,result:" + result3);
        //测试追加内容
        Stream<String> stream2 = list.stream();
        Optional<String> result2 = stream2.reduce((a, b) -> a + b);
        result2.ifPresent(v -> System.out.println("test8,result:" + v));
    }

    //收集结果 将stream转换称List Set String 或者Map(当前忽略)
    static void test9() {
        Stream<String> stream = list.stream();
        List<String> list1 = stream.collect(Collectors.toList());
        Set<String> set = list.stream().collect(Collectors.toSet());
        System.out.println("test9-1," + list1.size() + ":" + set.size());//set还是会过滤的

        //joining方法的参数是分隔符，可选
        String result = list.stream().collect(Collectors.joining(","));
        System.out.println("test9-2," + result);
    }

    //原始类型流IntStream LongStream DoubleStream
    static void test10() {
        IntStream intStream = IntStream.of(1, 3, 45, 6, 9);
        int[] arrays = intStream.toArray();
        //将int[] 转换成流，后面的参数可选
        IntStream intStream1 = Arrays.stream(arrays, 2, 4);

        IntStream intStream2 = IntStream.range(1, 100);

        Stream<Integer> stream = intStream1.boxed();//将原始流转换成对象流
    }


    //parallel并行 需要确保 并行操作都是线程安全的  以下方法没有测试出效果
    static void test11() {
        int[] arrays = new int[12];
        list.parallelStream().forEach(v -> {
            if (v.length() < 12) arrays[v.length()]++;
        });
        System.out.println("test11," + Arrays.toString(arrays));
    }

    //流不会收集自己的数据
    static void test12() {
        Stream<String> stream = list.stream();
        list.add("新加的一个");
        println("test12", stream);//stream中包含了上面 新加的一个

        //ConcurrentModificationException 不能在流中操作数据源
        try {
            Stream<String> stream2 = list.stream();
            stream2.forEach(v -> {
                if (v.length() > 3) {
                    list.add("在流操作中新加了一个");
                }
            });
        } catch (Exception e) {
            System.out.println("test12," + "Exception:" + e.getMessage());
        }
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
