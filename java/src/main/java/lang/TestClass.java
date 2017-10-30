package lang;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by yahier on 17/8/21.
 * Class类涉及到非常多的反射相关
 */

public class TestClass {

    public static int a = 100;
    public static final int num = 100;


    public static final void main(String[] args) {
        test2();

        System.err.println("value:" + Runtime.getRuntime().totalMemory() / 1024 / 1024);
    }

    //这个方法让反射来调用
    private static void go(String goWhere) {
        System.err.println("go:" + goWhere);
    }

    //注释？
    static void test1() {
        Class<TestClass> mClass = TestClass.class;

        //测试annotion.得到的是注解
        Annotation[] annos = mClass.getAnnotations();
        System.err.println(annos.length);
        for (Annotation anno : annos) {
            System.out.println(anno.toString());
        }

        //
        ClassLoader loder = mClass.getClassLoader();


    }

    //获取变量和常量，其实方法是一样的
    static void test2() {
        Class<TestClass> mClass = TestClass.class;
        //获取带了Field字段值
        try {
            Field f = mClass.getField("a");
            Field f2 = mClass.getField("num");
            a = 99;
            try {
                System.err.println("go:" + f.get(mClass.newInstance()));//打印99
                System.err.println("go:" + f2.get(mClass.newInstance()));//打印99
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }


    @
    interface ya {

    }

    static void test3() {
        Void v;
    }
}
