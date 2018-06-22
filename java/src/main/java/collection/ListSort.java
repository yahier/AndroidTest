package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pojo.People;

/**
 * Created by yahier on 2018/2/8.
 */

public class ListSort {
    static List<People> list = new ArrayList<>();

    static {
        list.add(new People("徐子旺", "008", 24));
        list.add(new People("独孤求败", "002", 30));
        list.add(new People("无双", "009", 18));
        list.add(new People("李三思", "008", 20));
        list.add(new People("无息", "", 60));
        list.add(new People("玄慈", "004", 80));
    }

    public static void main(String[] args) {
        testChange();
        randomSort();
    }

    static void randomSort() {
        Collections.shuffle(list);//这样就随机打乱了
        list.forEach(people -> System.out.println(people.getName()));
    }


    static void testChange(){
        //list.get(2).setName("wushuang");

        People people = list.get(2);
        people.setName("yayaya");
        //原来以上两种都可以，都不是一定要调用list.set(int ,people)的
    }

}
