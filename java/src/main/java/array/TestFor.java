package array;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by yahier on 17/8/21.
 * 测试for循环
 */

public class TestFor {

    public static final void main(String[] args) {
        //test();
        //test2();
        test4();
    }


    static void test() {
        String value = "+1245";
        long value1 = Long.valueOf(value);
        System.out.println(value1);
    }


    static void test2() {
        Set<String> set = new HashSet<>();
        set.add("晚风吹吹风");
        set.add("我在吃西瓜");
        set.add("门口池塘荷花摇啊摇");
        set.add("鸟儿渣渣叫");
        for (Iterator<String> iterator = set.iterator(); iterator.hasNext(); ) {
            System.err.println(iterator.next());
        }
    }

    //无限循环
    static void test3() {
        for (; ; ) {
            System.err.println(1);
        }
    }

    //初始化的变量必须同一个类型，如果以下的n是long类型，则会编译失败
    static void test4() {
        for (int i = 0, n = 2; i < n; i++) {
            System.out.println("徐子旺要称帝了");
        }
    }
}
