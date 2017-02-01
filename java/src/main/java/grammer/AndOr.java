package grammer;

/**
 * 很重要的多个测试
 */
public class AndOr {
    public static void main(String[] args) {
        //go();
        //te();
        getHashCode();
    }

    /**
     * 测试运行时配置参数,as在哪里配置呢
     *
     * @param args
     */
    static void testArgs(String[] args) {
        int length = args.length;
        System.out.println("长度是   " + length);
        for (int i = 0; i < length; i++) {
            System.out.println("...." + args[i]);
        }
    }

    /**
     * 测试 && 与 || 的运算顺序。是平级么
     */
    static void go() {
        System.out.println("go:" + (true && false || true));
    }

    static void te() {
        int a = 2, b = 3;
        if ((a | b) > 2) {
            System.out.println("te:");
        }
    }

    /**
     * >>>和>>的意义完全相同吗。为什么>>>可以编译,<<<不可以呢
     * <<向左移动,  >>向右移动
     */
    static void as() {
        int a = 4;
        a = a << 2;
        System.out.println("as:" + a);

    }

    static void getHashCode() {
        int a = 5;
        Integer inte1 = new Integer(a);
        Integer inte2 = new Integer(a);
        System.out.println(inte1.hashCode() + "  " + inte2.hashCode());

        String str1 = new String("yahier");
        String str2 = "yahier";
        String str3 = "yahier";
        System.out.println(str1.hashCode() + " " + str2.hashCode() + " "
                + str3.hashCode());// -738056074
        if (str1 == str2) {
            System.out.println(12);
        }

        if (str2 == str3) {
            System.out.println(23);// 被打印
        }


    }
}
