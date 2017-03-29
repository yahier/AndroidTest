package array;

import java.util.Arrays;

/**
 * Created by yahier on 17/3/29.
 * 快速排序
 */

public class FastSort {
    public static final void main(String[] args) {
        int[] data = {1, 6, 2, 8, 3, 4, 1};
        sort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }


    public static void sort(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int index = partition(array, lo, hi);
        sort(array, lo, index - 1);
        sort(array, index + 1, hi);
    }


    private static int partition(int[] array, int lo, int hi) {
        //固定的切分方式
        int key = array[lo];
        while (lo < hi) {
            while (array[hi] >= key && hi > lo) {//从后半部分向前扫描
                hi--;
            }
            array[lo] = array[hi];
            while (array[lo] <= key && hi > lo) {//从前半部分向后扫描
                lo++;
            }
            array[hi] = array[lo];
        }
        array[hi] = key;
        return hi;
    }


}
