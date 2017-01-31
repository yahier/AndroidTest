package annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试注解,建立注解。并且取值。
 */
public class Test {

    public static void main(String[] args) throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, InvocationTargetException {

        testReflect();
    }

    //测试注解
    static void test1() throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException {

        Class<Other> c = Other.class;
        Method method = c.getMethod("doOther");
        Bingo bingo = method.getAnnotation(Bingo.class);
        System.out.println("注释值是:" + bingo.num());
    }

    //顺便测试反射
    static void testReflect() throws ClassNotFoundException,
            InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, InvocationTargetException {
        //Class<Other> c = Other.class;
        Other o = new Other();
        Class<Other> c = (Class<Other>) o.getClass();
        //Object obj = f.get(o);
        //获取变量相关
        Field[] fs = c.getDeclaredFields();
        for (Field f : fs) {
            System.out.println(f.getName());//显示变量的命名
            //获取变量值
            int value = f.getInt(o);
            System.out.println(value);
        }

        System.out.println();
        //获取方法相关
//        Method[] ms = c.getMethods();//测试发现 只获取了public方法
//        for (Method m : ms) {
//            System.out.println(m.getName());
//        }

        //调用方法1
        Method m1 = c.getDeclaredMethod("v", null);
        m1.setAccessible(true);
        int value = (int) m1.invoke(o);
        System.out.println("value:" + value);

        //调用方法2.加上了参数
        Method m2 = c.getDeclaredMethod("add", new Class<?>[]{int.class, int.class});
        m2.setAccessible(true);
        int value2 = (int) m2.invoke(o, 5, 6);
        System.out.println("value2:" + value2);

    }

}