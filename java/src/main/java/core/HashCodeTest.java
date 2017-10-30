package core;

import java.util.HashMap;

/**
 * Created by yahier on 17/2/8.
 * 对于普通对象, == 和 equal 是相同的,比较对象引用.hashcode也是一样的。（对象的内部地址转换成一个整数来实现的。）
 * 对于String。hashcode是内容有关,如果equal为true,hashcode一定是true,反之不一定
 */

public class HashCodeTest {
    public static void main(String[] args) {
        compareStr();
        compareStrHash();
    }

    static void compareStr() {
        String str1 = new String("yahier");
        String str2 = new String("yahier");
        String str3 = "yahier";

        System.out.println(str1.hashCode() + " " + str2.hashCode() + " " + str3.hashCode());//三个相等的 -738056074

        if (str1.hashCode() == str2.hashCode() && str2.hashCode() == str3.hashCode()) {
            System.out.println("三个的hashcode是相同的");
        } else {
            System.out.println("hashcode值不同");
        }

        if (str1.equals(str2) && str2.equals(str3)) {
            System.out.println("三个的值是相同的");
        }


        if (str1 == str2) {
            System.out.println(12);
        }

        if (str2 == str3) {
            System.out.println(23);//被打印
        }


    }


    //查看String的hashcode就明白了
    static void compareStrHash() {
        String str4 = "hgebcijedg";
        String str5 = "gdejicbegh";
        String str6 = "hgebcijedg";
        //比较str4和str5
        if (str4.hashCode() == str5.hashCode()) {
            System.out.println("str 4 5的hashcode相等");
        } else {
            System.out.println("str 4 5的hashcode不等");
        }

        HashMap<String,String> map = new HashMap<>();
        map.put(str4,"yahier");
        System.out.println("value1:"+map.get(str4));
        System.out.println("value2:"+map.get(str5));
        System.out.println("value2:"+map.get(str6));
    }

    static void compareObj() {
        HashCodeTest t1 = new HashCodeTest();
        HashCodeTest t2 = new HashCodeTest();
        if (t1 == (t2)) {
            System.out.println("compareObj equal");//被打印
        }
        if (t1.hashCode() == t2.hashCode()) {
            System.out.println("compareObj hashcode");//被打印
        }

    }
}
