package string;

import myutil.Log;

/**
 * Created by yahier on 17/4/10.
 */

public class Core {
    static final String TAG = "Core";

    public static final void main(String[] args) {
        //test1();
        //testOX();

//        String value = saveTwoDecimal(12.000);
//        System.out.println("value:" + value);
//
//        double a = 0.95;
//        System.out.println("value:" + (int) a);

        test333();

    }


    private static String saveTwoDecimal(double value) {
        return String.format("%.1f", value);
    }

    private static void testOX() {
        String value = Integer.toHexString(14);
        System.out.println("value:" + value);
    }

    private static void test333(){
        String s1 = "[\"storeCouponSelected\"]";
        String s2 = s1.replace("\\","");
        System.out.println("s2:"+s2);
    }

    /**
     * 测试String地址
     */
    static void test1() {
        String s1 = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        Log.e(TAG, (s1 == s2));//true
        Log.e(TAG, (s1 == s3));//false
        Log.e(TAG, (s1.intern() == s3.intern()));//true

        //从结果分析，str1和str2引用了相同的地址，str3和str1指向的常量地址是一样的。
    }

}
