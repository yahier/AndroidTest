package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Collection与array的互换
 */
public class ListToArray {
    public static void main(String[] args) {
        test1();
        test2();
    }

    /**
     * toArray(T[] a)方法。如果传参长度不够，会自动扩充。如果参数长度超过list,后面会补充null
     */
    static void test1() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);


        Integer[] array = list.toArray(new Integer[0]);
        Object[] array2 = list.toArray();

        System.out.println("array2 length " + array2.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }


    /**
     * 数组转成List
     */
    static void test2() {
        Integer[] data = new Integer[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = i;
        }

        List<Integer> list = Arrays.asList(data);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }


    private static Integer[] to(int[] data) {
        Integer[] integers = new Integer[data.length];
        for (int i = 0; i < integers.length; i++) {
            integers[i] = data[i];
        }
        return integers;
    }
}
