package core;

public class Basic {
    public static void main(String[] args) {
        //mu();
        //System.out.println(isOdd(-2));
        //test2(1);
        test4();
    }

    static void mu() {
        System.out.println(2.00 - 1.10);// 0.89999999999
    }


    static boolean isOdd(int a) {
        return a % 2 == 0;
    }

    static void test2(int value) {
        switch (value) {
            case 1:
                System.out.print(1);
                break;
            case 2:
                System.out.print(2);
                break;
        }
    }

    static void test3() {
        boolean b1 = false;
        boolean b2 = true;
        boolean b3 = true;

        if (b1 || b2 && b3) {
            System.err.println("if");
        } else
            System.err.println("else");

    }

    static void test4() {
        int b1 = 1;
        int b2 = 2;
        int b3 = 3;

        if (++b1 > 1 || (b1 > b2 && --b2 > 2)) {
            System.err.println("if-" + b1 + ":" + b2);
        } else
            System.err.println("else-" + b1 + ":" + b2);

    }
}
