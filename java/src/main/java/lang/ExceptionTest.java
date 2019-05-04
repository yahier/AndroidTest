package lang;

public class ExceptionTest {
    public static void main(java.lang.String[] args) {
        //test1();
        test2();
    }


    /**
     * 测算异常捕捉的性能损耗  重复1000,000次，分别是4ms和2ms
     */
    static void test1() {
        int size = 1000000;

        {
            long time1 = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                try {
                    int a = 5 / 2;
                } catch (Exception e) {
                    //System.out.println();
                }
            }
            long time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
        }

        {
            long time3 = System.currentTimeMillis();
            for (int i = 0; i < size; i++) {
                int b = 5 / 2;
            }
            long time4 = System.currentTimeMillis();
            System.out.println(time4 - time3);
        }
    }


    /**
     * switch语法的性能 并没有比连续的if 好
     */
    static void test2() {
        java.lang.String tag = "000";
        int repeatTimes = 1000000;
        {
            long time1 = System.currentTimeMillis();
            for (int i = 0; i < repeatTimes; i++) {
                if (tag.equals("0")) {

                } else if (tag.equals("00")) {

                } else if (tag.equals("000")) {

                }
            }
            long time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
        }
        {
            long time1 = System.currentTimeMillis();
            for (int i = 0; i < repeatTimes; i++) {
                switch (tag) {
                    case "0":
                        break;
                    case "00":
                        break;
                    case "000":
                        break;
                }
            }
            long time2 = System.currentTimeMillis();
            System.out.println(time2 - time1);
        }

    }
}
