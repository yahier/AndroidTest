package array;

//测试下 数组复制
public class Copy {
    private static int[] a = {1, 2, 3, 4, 5};

    public static void main(String[] args) {
        test();

    }

    private static void test() {
        int[] b = new int[5];
        System.arraycopy(a, 1, b, 2, 3);

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }

    }


    private static void test2() {
        char a = 'a', b = 'a';
        System.out.println(a + 1);
        if (a == b) {
            System.out.println(123);
        }

    }


}
