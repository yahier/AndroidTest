package java8;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.nio.file.Paths.get;

/**
 * Created by yahier on 2018/1/23.
 * 测试java8一些杂项改进 包括String的join方法，集合相关的新方法，文件操作 Base64 正则表达式相关
 */

public class StringTest {
    static List<String> list = new ArrayList<>();

    static {
        list.add("3路桥川");
        list.add("浩哥");
        list.add("1楚连翘");
        list.add("1林落雪");
        list.add("李殊词");
        list.add("1钟白");
        list.add("2毕十三");
        list.add("3任一凡");
    }

    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test6();
    }

    //测试String的join方法
    static void test1() {
        String result = String.join("-", "a", "b", "c", "d");//第一个参数是分隔符
        println("test1", result);
    }

    //测试集合的方法
    static void test2() {
        list.removeIf(str -> str.contains("李殊词"));
        list.forEach(System.out::println);

        System.out.println();

        list.replaceAll((str) -> {
            if (str.contains("钟白")) {
                return "yahier爱钟白";
            } else {
                return str;
            }
        });
        list.forEach(System.out::println);
        System.out.println();

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String s, String t1) {
                return s.compareTo(t1);
            }
        });
        list.forEach(System.out::println);
    }

    //测试文件
    static void test3() {
        String filePath = "/Users/yahier/Desktop/test2";
        Path path = get(filePath);
        try {
            List<String> streams = Files.readAllLines(path, StandardCharsets.UTF_8);
            streams.forEach(System.out::println);

            Stream<String> stream = Files.lines(path);
            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Stream<String> lines = Files.lines(path)) {
            Optional<String> optional = lines.filter(s -> s.contains("y")).findFirst();
            println("test3 2:", optional.get());//NoSuchElementException: No value present
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            println("test3 3:", new String(Files.readAllBytes(get(filePath))));
            Files.lines(Paths.get(filePath), StandardCharsets.UTF_8).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //测试自带的Base64编码
    static void test4() {
        final String value = "yahier要很厉害";
        String encoderStr = Base64.getEncoder().encodeToString(value.getBytes(StandardCharsets.UTF_8));
        println("test4:1", encoderStr);

        String backStr = new String(Base64.getDecoder().decode(encoderStr), StandardCharsets.UTF_8);
        println("test4:2", backStr);
    }

    //null检查
    static void test5() {
        boolean anyNull = list.stream().anyMatch(Objects::isNull);
        boolean nonNull = list.stream().anyMatch(Objects::nonNull);
    }

    //正则表达式 捕捉组与命名捕捉组
    static void test6() {
        final String value = "2008-12-31";
        Pattern pattern = Pattern.compile("(\\d{4})-(\\d{2}-(\\d\\d))");
        Matcher matcher = pattern.matcher(value);
        if (matcher.matches()) {
            String result = matcher.group();
            println("test6", result);//2008-12-31
        }

        Pattern pattern2 = Pattern.compile("(?<year>\\d{4})-(?<date>\\d{2}-(?<day>\\d\\d))");
        Matcher matcher2 = pattern2.matcher(value);
        if (matcher2.matches()) {
            String result = matcher2.group("year");
            println("test6", result);//2008
        }

        //厉害了
        Stream<String> stream = list.stream().filter(Pattern.compile("[桥川|钟白]").asPredicate());
        stream.forEach(System.err::println);
    }

    static void println(String tag, String value) {
        System.out.println(tag + "," + value);
    }
}
