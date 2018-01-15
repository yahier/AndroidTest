package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Created by yahier on 2018/1/15.
 * 测试java8的类型推断
 */

public class TypeJudge {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
    }

    static void test1() {
        IntStream.rangeClosed(1, 2)
                .forEach((int number) -> System.out.println(number * 2));

        System.out.println();

        //包括了3.没有包括4
        IntStream.range(3, 4)
                .forEach((number) -> System.out.println(number * 2));

        System.out.println();

        int[] a = {12, 356, 7};
        IntStream.of(a).forEach(System.out::println);
    }

    static void test2() {
        List<String> list = new ArrayList();
        list.add("徐子旺");
        list.add("神");
        list.add("空海");
        list.add("玉环");
        list.add("徐小小");
        List<String> list2 = list.stream()
                .filter((data) -> data.startsWith("徐"))
                .collect(toList());

        list2.forEach(System.out::println);
    }

    static void test3() {
        List<String> list = new ArrayList();
        list.add("徐子旺");
        list.add("神");
        list.add("空海");
        list.add("玉环");
        list.add("徐小小");
        //这里的过滤方法里的参数仍然是List，而不是String
        Stream<List<String>> list2 = Stream.of(list).filter((data) -> data.add("李白")).sorted();
        list2.forEach(System.out::println);
    }
}
