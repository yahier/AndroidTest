package string;

/**
 * Created by yahier on 11/1/18.
 */

public class TransferTest {

    public static void main(String[] args) {
        //method1();
        method2();
    }

    // 测试引用传递：StringBuffer
    private static void method1() {
        StringBuffer str = new StringBuffer("仁慈");
        System.out.println(str);//仁慈
        change1(str);
        System.out.println(str);//仁慈
    }

    private static void change1(StringBuffer str) {
        //新建了一个StringBuffer对象，所以str指向了另外一个地址，相应的操作也同样是指向另外的地址的。
        str = new StringBuffer("abc");
        str = str.append("sss");

    }


    /**
     * 测试String传值、String建立就不会改变
     */
    private static void method2() {
        String str = new String("yahier");
        System.out.println(str);
        change2(str);
        System.out.println(str);//输出yahier
    }

    private static void change2(String str) {
        str = "abc"; //输出：yahier
        //str = new String("abc"); //输出：公众号：Java面试通关手册
    }

}
