package algorithm.math;

public class MathUtils {
    /**
     * 计算末尾0的个数
     * 10!
     */
    public static void calculateSizeOfLast0() {
        int min = 1;
        int max = 20;
        int sizeOf0 = 0;
        long value = 1;
        for (int i = min; i <= max; i++) {
            if (i % 5 == 0) {
                sizeOf0++;
            }
            value = value * i;
        }

        System.out.println("sizeOf0:" + sizeOf0 + " value:" + value);

    }

    /**
     * 计算表达式
     * 如果加上()多层嵌套。嘿嘿
     */
    public static void calculateExpress() {
        String express = "1+(2-3*4)+2/2-4*4/2";
        get(express);


    }


    /**
     * 得到字符串内第一个()内的内容
     */
    public static String get(String str) {
        int index1 = str.indexOf("(");
        int index2 = str.indexOf(")");

        if (index1 < 0 || index2 < 0) {
            return "";
        }

        str = str.substring(index1, index2 + 1);
        System.out.println("str" + str);
        return str;

    }

    /**
     * 用来计算递归式的() 当前默认此表达式已经没有()了
     */
    private static String calculate(String express) {
        //先找到 * / ，将两边的数字计算完成之后 替换到这个字符串中
        int indexMul = indexOf(express, "*");
        int indexDivide = indexOf(express, "/");
        int indexAdd = indexOf(express, "+");
        int indexSub = indexOf(express, "-");

        if (indexMul < Integer.MAX_VALUE || indexDivide < Integer.MAX_VALUE) {
            //先做乘法
            if (indexMul < indexDivide) {

            }
        }
        return "";
    }

    private static int indexOf(String str, String key) {
        int index = str.indexOf(key);
        if (index < 0)
            index = Integer.MAX_VALUE;
        return index;
    }

    private static int calculate(String type, int num1, int num2) {
        switch (type) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":
                return num1 / num2;
        }
        return 0;
    }

    /**
     * 比较两个数的大小  很繁琐的简单的算法
     * 不能用-  也不用Math类的方法
     */
    public static void compare(int a, int b) {
        String strA = String.valueOf(a);
        String strB = String.valueOf(b);

        int indexA = strA.indexOf("-");
        int indexB = strB.indexOf("-");


        int length1 = strA.length();
        int length2 = strB.length();

        //A是负数
        if (indexA >= 0) {
            if (indexB >= 0) {
                //B是负数
                strA = strA.substring(1);
                strB = strB.substring(1);
                if (length1 > length2) {
                    System.out.println("a<b");
                } else if (length1 < length2) {
                    System.out.println("a>b");
                } else {
                    //遍历从高位开始比较
                }

            } else {
                //B是正数
                System.out.println("a<b");
            }
            //A是正数
        } else {
            //B是负数
            if (indexB >= 0) {
                System.out.println("a>b");
            } else {
                //todo pass
            }
        }


    }
}
