package fanxing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yahier on 1/29/19.
 * 泛型测试的调用类
 * 泛型，参数化类型 。自己的理解是(编译时指定传参类型的方案，主要好处是解决运行过程中数据类型转换的错误)
 */

public class Invoker {
    public static void main(String[] args) {
        test1();
        test2();

    }

    private static void test1() {
        Generic<String, String> generic1 = new Generic<>("yahier");
        Generic<Integer, Integer> generic2 = new Generic<>(2);
        System.out.println(generic1.getKey() + "    " + generic2.getKey());
    }

    private static void test2() {
        FruitGenerator<String> fruitGenerator = new FruitGenerator<>();
        String moral = fruitGenerator.next("yahier will be happy");
        System.out.println(moral);
    }


    /**
     * 泛型数组 不能创建一个确切的泛型类型的数组
     */
    private static void test3() {
        //List<String>[] list1 = new ArrayList<String>[10];编译错误
        List<String>[] list2 = new ArrayList[10];
        List<?>[] list3 = new ArrayList<?>[10];
    }

    /**
     * 定义泛型方法1
     */
    private <E> E genericMethod(Class<E> tClass) throws InstantiationException,
            IllegalAccessException {
        E instance = tClass.newInstance();
        return instance;
    }


    /**
     * 定义泛型方法2
     */
    private <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("t is " + t);
        }
    }

}
