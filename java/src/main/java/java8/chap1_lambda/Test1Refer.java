package java8.chap1_lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yahier on 2018/1/22.
 * 测试引用
 */

public class Test1Refer {


    public static void main(String[] args) {
        test1(() -> {

        });

        test2((String str) -> {

        });

        test2((str) -> {

        });

        test2(str -> {

        }, "yahier");

        //方法引用
        test1(Test1Refer::test);
        test1(Test1Refer::new);
        test2(Test1Refer::test);

        testFor();

        practice6();
    }


    Test1Refer() {
        System.err.println("空参数的构造函数");
    }

    //测试接口默认方法forEach
    static void testFor() {
        List<String> list = new ArrayList<>();
        list.add("yahier");
        list.add("一统江湖");
        list.forEach(System.out::println);
    }

    //测试接口默认方法和经静态方法
    void tesCompare() {
        List<String> list = new ArrayList<>();
        list.add("yahier");
        list.add("一统江湖");

        Collections.sort(list, (str1, str2) -> {
            return str1.compareTo(str2);
        });
        Collections.sort(list, Comparator.naturalOrder());

        Comparator<Integer> com = (f, s) -> Integer.compare(f, s);//方法怪异，怎么调用呢，难道只是给两个变量排序么

        Comparator<String> comparator = new DogSizeComparator();
        //奇怪为什么一直编译出错
        //Arrays.sort(list, comparator);//Arrays sort in arrays cannot be applied

    }

    class DogSizeComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.compareTo(o2);
        }
    }


    static void test() {
        System.err.println("test");
        //System.err::println();
        //System.out::println;
    }

    static void test(String str) {
        //System.err::println();
        //System.out::println;
    }

    static void test1(OnClickListener listener) {
        listener.onClick();
        listener.go();
    }

    static void test2(OnClickListener2 listener2) {
        System.err.println("test2 listener");
        listener2.onClick("yahier");
    }

    static void test2(OnClickListener2 listener2, String str) {
        System.err.println("test2 listener");
        listener2.onClick("yahier");
    }


    interface OnClickListener {
        void onClick();

        //接口默认方法，需要加default关键字
        default void go() {
            System.out.println("默认方法");
        }
    }

    interface OnClickListener2 {
        void onClick(String str);
    }


    //练习6的测试:封装Runnable中的异常捕捉
    private static void practice6() {
        System.out.println("practice1 " + Thread.currentThread().getName());
        new Thread(uncheck(
                () -> {
                    System.out.println("in Thread " + Thread.currentThread().getName());
                    Thread.sleep(100);
                })).start();
    }

    private static Runnable uncheck(RunnableEx runnableEx) {
        return () -> {
            try {
                runnableEx.run();
                System.out.println("practice1 in uncheck " + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    }

    interface RunnableEx {
        void run() throws Exception;
    }


    private void practice7() {

    }

    //返回一个 分别运行这两个实例的Runnable对象
    static void andThen(Runnable run1, Runnable run2) {
        run1.run();
        run2.run();
    }
}
