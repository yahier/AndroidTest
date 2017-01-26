package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by yahier on 17/1/26.
 * 测试对象排序。分别给
 */

public class SortObj {
    public static void main(String[] args){

        new SortObj().test1();
    }

    void test1() {
        People p1 = new People(12, "yahier");
        People p2 = new People(2, "soso");
        People p3 = new People(24, "bingo");

        List<People> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);


        Collections.sort(list, new Comparator<People>() {
            @Override
            public int compare(People a, People b) {
                //这三种方法都通过测试啦。
                //return a.getName().compareTo(b.getName());
                //return a.getAge()-b.getAge();
                return a.compareTo(b);
            }
        });

        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i).getAge());
        }

    }
}
