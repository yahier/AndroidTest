package java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaTest {
    String value = "default";

    public static void main(String[] args) {

        test1();
        test2(() -> "yahier");
        test3(str -> {
            String value = str;
            System.err.println("main test3," + value);
        });
        test4(s -> {
            System.err.println("main test4," + s);
            return 3;
        });

        test5(s -> {
            System.err.println("main test5," + s);
            return s.equals("yahier");
        });

        test5(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                System.err.println("main test5," + s);
                return s.equals("yahier");
            }
        });

        test6(() -> System.err.println("main test6"));
    }

    static void test1() {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.compareTo(b);
            }
        });


        String[] array = new String[4];
        names.toArray(array);
        System.out.println(Arrays.toString(array));
    }

    static void test2(Supplier<String> supplier) {
        String value = supplier.get();
        System.err.println("test2," + value);
    }

    static void test3(Consumer<String> consumer) {
        consumer.accept("test3 赋值");//调用方会处理
    }

    static void test4(Function<String, Integer> function) {
        int value = function.apply("yahier");
        System.err.println("test4," + value);
    }

    static void test5(Predicate<String> predicate) {
        boolean isYahier = predicate.test("yahier");
        System.err.println("test5," + isYahier);
    }

    static void test6(Runnable run) {
        run.run();
    }

    static void test7(){
        Object obj = "yhier";
       // boolean yahier = Predicate.isEqual("");
    }

}

