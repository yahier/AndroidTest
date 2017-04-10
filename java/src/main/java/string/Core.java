package string;

import myutil.Log;

/**
 * Created by yahier on 17/4/10.
 */

public class Core {
    static final String TAG = "Core";

    public static final void main(String[] args) {
        test1();
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
