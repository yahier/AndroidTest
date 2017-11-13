package core;

/**
 * Created by lenovo on 2017/11/13.
 */

public class StaticTest {
    private static StaticTest test = new StaticTest();//执行后 count1是1，county也是1
    public static int count1;
    public static int count2 = 0;

    private StaticTest(){
        count1++;
        count2++;
    }

    public static StaticTest getInstance(){
        return test;
    }

    public final static void main(String[] args){
        StaticTest test = getInstance();
        System.out.println(test.count1+":"+test.count2);//1和0
    }
}
