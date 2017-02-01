package core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    //初始条件,判断条件,条件改变
    public void test() {
        //这两个for循环的效果是一样的
        //for(int i=0;;){
        for (; ; ) {
            try {
                Thread.sleep(2000);
            } catch (Exception e) {

            }
            System.out.println("Key:");
        }
    }

    public static void main(String avgs[]) {
        Test t = new Test();
        t.test();
    }
}