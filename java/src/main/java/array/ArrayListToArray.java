package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ArrayListToArray {
    public static void main(String[] args) {
        ArrayListToArray o = new ArrayListToArray();
        //o.change();
        o.test();
        o.test2();
    }

    void change() {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 8; i++) {
            list.add(i);
        }

        Object[] a1 = list.toArray();
        String str = Arrays.toString(a1);
        str = str.replace('[', '(');
        str = str.replace(']', ')');

        System.out.println(str);
    }

    void test() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                }
                if (o1 < o2) {
                    return -1;
                }
                return 0;
            }
        });


        Stream.of(list).forEach(System.out::println);

        List<String> list2 = Arrays.asList("yahier","soso","being");
        Stream.of(list2).forEach(System.out::println);

    }

    void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(4);
        Collections.sort(list);


        Stream.of(list).forEach(item -> System.out.println(item));

    }

    void test1() {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < 8; i++) {
            list.add(i);
        }
        Integer[] data = new Integer[8];
        data = list.toArray(data);

    }

}
