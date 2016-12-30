package core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Test {
    public void a(Map a, String b) {
        a.put("test", b);
    }

    public void b() {
        Map a = new HashMap();
        a.put("test", "a");
        String b = "b";
        // printMap(a);
        a(a, b);
        printMap(a);
    }

    public void printMap(Map a) {
        Set set = a.entrySet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry) it.next();
            System.out.println("Key:" + e.getKey() + " Value:" + e.getValue());

        }
    }


    //初始条件,判断条件,条件改变
    public void test() {
        for(int i=0;;){
        //for (; ; ) {
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