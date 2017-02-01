package grammer;

/**
 * 测试下 int与char的转换
 */
public class intchar {
    public static void main(String[] args) {
        t();
    }

    static void t() {
        int a = 49;
        char chara = (char) a;//1.为什么是1

        int c1 = (int) 'a';//97
        int c2 = (int) 'A';//65
        char c3 = 97;//a
        char c4 = 65;//A

        System.out.println(chara  + "-" + c1 + "-" + c2);
        System.out.println(c3 + "-" + c4);
    }
}
