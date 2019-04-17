package algorithm.array;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 数组工具类
 */
public class ArrayUtil {
    static int[] data = {1, 2, 3, 3, 4, 5, 5, 9, 7, 3, 10};
    static int[] dataOrder = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    static int[] data3 = {4, 5, 6, 7, 8, 2, 3};


    /**
     * 获取三个数组的公共数据
     */
    private static void getCommonDataIn3Array() {
        //思路1，遍历数组1，依次查询元素是否同时存在数组2和数组3中

    }

    /**
     * 冒泡排序
     */
    static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = i; j < data.length; j++) {
                if (data[i] > data[j]) {
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }

        System.out.println("排序后：" + Arrays.toString(data));
    }

    /**
     * 二分排序
     */
    static void binarySort(int[] data) {
        for (int i = 0; i < data.length; i++) {

        }

        System.out.println("排序后：" + Arrays.toString(data));
    }

    /**
     * 将数组向右旋转 offSize可能是0
     */
    public static void rotateRight(int[] data, int offSize) {
        if (offSize > data.length || offSize < -data.length) {
            throw new IllegalArgumentException("偏移量的绝对值不能超过数组长度");
        }
        int[] newArrays = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            //算式的推导方式是 假设法 然后调整
            int j = (i + data.length - offSize) % data.length;
            newArrays[i] = data[j];

        }

        System.out.println("数组内容:" + Arrays.toString(newArrays));
    }


    /**
     * 寻找最大数目
     */
    public static void getBiggest() {
        int max = -Integer.MAX_VALUE;
        for (int temp : data) {
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println("max:" + max);
    }

    /**
     * 寻找数组重复的元素
     */
    public static void findRepeat() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (i != j && data[i] == data[j]) {
                    System.out.println("重复元素是:" + data[i]);
                    break;
                }
            }
        }
    }


    /**
     * 寻找数组重复性最多的元素 todo 待续
     */
    public static void findMostRepeat() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : data) {
            int count = map.get(i);
            map.put(i, count++);
        }

        Set<Integer> keys = map.keySet();
        Collection<Integer> values = map.values();
        //找到values最大的次数
        //再去找到这个最大次数 找到对应的key
    }


}
