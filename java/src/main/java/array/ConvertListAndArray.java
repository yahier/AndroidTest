package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 测试 列表 和 数组的转换 关键是toArray方法
 */
public class ConvertListAndArray {
    public static void main(String[] args) {
        listToArray();
        arrayToList();
    }

    private static void listToArray() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            list.add(i);
        }


        {
            Integer[] intArray = new Integer[list.size()];
            //todo 这个方法，如果数组长度和list长度相同，可以直接复制，不用方法返回值
            list.toArray(intArray);
            System.out.println("listToArray1:" + Arrays.toString(intArray));

            Integer[] intArray2 = new Integer[1];
            //todo 这里长度不同，传参的数组不会得到复制
            list.toArray(intArray2);
            System.out.println("listToArray2:" + Arrays.toString(intArray2));
        }

        {
            Integer[] intArray = new Integer[0];
            //取方法返回值的意思是，无论数组长度多少，方法返回的数组长度和list长度相同
            intArray = list.toArray(intArray);
            System.out.println("listToArray3:" + Arrays.toString(intArray));

        }

        {
            //运行错误
           //Integer[] integers = (Integer[]) list.toArray();
           //System.out.println("listToArray4:" + Arrays.toString(integers));
        }

    }


    private static void arrayToList() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);

    }
}
