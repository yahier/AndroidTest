package core;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by yahier on 17/3/2.   point
 * 需要重载的equals和hashCode方法都相等,才算是同一个对象。  point
 */

public class OverrideTest {
    private final char first;
    private final char second;

    public OverrideTest(char first, char second) {
        this.first = first;
        this.second = second;
    }



    @Override
    public boolean equals(Object o) {
        //System.out.println("equals Object");
        if(!(o instanceof OverrideTest))return false;
        OverrideTest t =(OverrideTest)o;
        return first == t.first && second == t.second;
    }


    //压根没有调用此方法
    public boolean equals(OverrideTest t) {
        System.out.println("equals");
        return first == t.first && second == t.second;
    }


    public int hashCode() {
        //System.out.println("hashCode");
        return  first + second;
    }

    public final static void main(String[] args) {
        Set<OverrideTest> set = new HashSet<OverrideTest>();
        for (int i = 0; i < 10; i++) {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                set.add(new OverrideTest(ch, ch));
            }
        }

        System.out.println(set.size());
    }

}
