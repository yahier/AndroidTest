package core;

/**
 * 测试块
 */
public class Kuai {
    static int a = 1;

    public static void main(String[] args) {
        Kuai kuai = new Kuai();
        Integer[] b = {1, 2, 3};
        kuai.test();
    }

    void test() {
        {
            System.out.println(a);
        }
        {
            System.out.println(++a);
        }
        {
            System.out.println(123);
        }

    }

    static {
        a++;
        System.out.println("static");
    }

    String to(String... strings) {
        String str = strings[2];
        System.out.println(str);
        return str;
    }

    Integer ya(Integer... a) {
        try {
            System.out.println(a[0]);
        } finally {

        }
        return a[0];
    }
}
